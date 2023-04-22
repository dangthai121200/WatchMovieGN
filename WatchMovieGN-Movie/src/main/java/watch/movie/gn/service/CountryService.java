package watch.movie.gn.service;

import watch.movie.gn.domain.CreateCountryRequest;
import watch.movie.gn.domain.GetAllCountryReponse;

public interface CountryService {

	GetAllCountryReponse getAllCountry();

	void createCountry(CreateCountryRequest createCountryRequest);
}
