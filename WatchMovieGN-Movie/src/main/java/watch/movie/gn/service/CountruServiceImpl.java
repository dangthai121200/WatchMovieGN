package watch.movie.gn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import watch.movie.gn.domain.CountryDomain;
import watch.movie.gn.domain.CreateCountryRequest;
import watch.movie.gn.domain.GetAllCountryReponse;
import watch.movie.gn.entity.Country;
import watch.movie.gn.repository.CountryRepository;
import watch.movie.gn.util.ConvertUtil;

@Service
public class CountruServiceImpl implements CountryService {

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

	@Override
	public void createCountry(CreateCountryRequest createCountryRequest) {
		List<Country> countries = ConvertUtil
				.convertListCountryDomainToListCountry(createCountryRequest.getCountries());
		countryRepository.saveAll(countries);
	}

}
