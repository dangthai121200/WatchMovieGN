package watch.movie.gn.service;

import watch.movie.gn.domain.country.GetAllCountryReponse;

public interface CountryService {

	GetAllCountryReponse getAllCountry();

	void updateCountryEnumsIntoDatabase();
}
