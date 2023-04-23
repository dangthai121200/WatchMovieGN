package watch.movie.gn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import watch.movie.gn.domain.CountryDomain;
import watch.movie.gn.domain.CreateCountryRequest;
import watch.movie.gn.domain.DeleteCountryRequest;
import watch.movie.gn.domain.GetAllCountryReponse;
import watch.movie.gn.domain.UpdateCountryRequest;
import watch.movie.gn.entity.Country;
import watch.movie.gn.exception.WatchMovieException;
import watch.movie.gn.repository.CountryRepository;
import watch.movie.gn.util.ConvertUtil;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	public CountryRepository countryRepository;

	@Override
	public GetAllCountryReponse getAllCountry() {
		GetAllCountryReponse getAllCountryReponse = new GetAllCountryReponse();
		List<Country> countries = countryRepository.findAll();
		List<CountryDomain> countryDomains = ConvertUtil.convertListCountryToListCountryDomain(countries);
		getAllCountryReponse.setCountries(countryDomains);
		return getAllCountryReponse;
	}

	@Transactional(rollbackOn = Exception.class)
	@Override
	public void createCountry(CreateCountryRequest createCountryRequest) {
		List<Country> countries = ConvertUtil
				.convertListCountryDomainToListCountry(createCountryRequest.getCountries());
		countryRepository.saveAll(countries);
	}

	@Transactional(rollbackOn = Exception.class)
	@Override
	public void updateCountry(UpdateCountryRequest updateCountryRequest) throws WatchMovieException {
		List<Country> countries = ConvertUtil
				.convertListCountryDomainToListCountry(updateCountryRequest.getCountries());
		for (Country country : countries) {
			if (country.getPkIdCountry() == null) {
				throw new WatchMovieException("Id is request for update");
			}
		}
		countryRepository.saveAll(countries);
	}

	@Transactional(rollbackOn = Exception.class)
	@Override
	public void deleteCountry(DeleteCountryRequest deleteCountryRequest) {
		if (!deleteCountryRequest.getCountryIdList().isEmpty()) {
			countryRepository.deleteAllByIdInBatch(deleteCountryRequest.getCountryIdList());
		}
	}

}
