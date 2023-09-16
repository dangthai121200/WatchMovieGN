package watch.movie.gn.service;

import watch.movie.gn.domain.GetAllCountryReponse;

public interface CountryService {

	GetAllCountryReponse getAllCountry();

	void updateCountryEnumsIntoDatabase();
}
