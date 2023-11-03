package watch.movie.gn.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import watch.movie.gn.domain.country.CountryDomain;
import watch.movie.gn.domain.country.GetAllCountryResponse;
import watch.movie.gn.entity.Country;
import watch.movie.gn.enums.CountryEnum;
import watch.movie.gn.repository.CountryRepository;
import watch.movie.gn.util.ConvertUtil;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	public CountryRepository countryRepository;

	@Override
	public GetAllCountryResponse getAllCountry() {
		GetAllCountryResponse getAllCountryReponse = new GetAllCountryResponse();
		List<Country> countries = countryRepository.findAll();
		List<CountryDomain> countryDomains = ConvertUtil.convertListCountryToListCountryDomain(countries);
		getAllCountryReponse.setCountries(countryDomains);
		return getAllCountryReponse;
	}

	@Override
	public void updateCountryEnumsIntoDatabase() {
		List<Country> countries = new ArrayList<>();
		for (CountryEnum countryEnum : CountryEnum.values()) {
			Country country = new Country();
			country.setPkIdCountry(countryEnum.getPkIdCountry());
			country.setName(countryEnum.getName());
			country.setCode(countryEnum.getCode());
			countries.add(country);
		}
		countryRepository.saveAll(countries);
	}

}
