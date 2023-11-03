package watch.movie.gn.service;

import watch.movie.gn.domain.country.GetAllCountryResponse;

public interface CountryService {

	GetAllCountryResponse getAllCountry();

	void updateCountryEnumsIntoDatabase();
}
