package watch.movie.gn.service;

import watch.movie.gn.domain.CreateCountryRequest;
import watch.movie.gn.domain.DeleteCountryRequest;
import watch.movie.gn.domain.GetAllCountryReponse;
import watch.movie.gn.domain.UpdateCountryRequest;
import watch.movie.gn.exception.WatchMovieException;

public interface CountryService {

	GetAllCountryReponse getAllCountry();

	void createCountry(CreateCountryRequest createCountryRequest);

	void updateCountry(UpdateCountryRequest updateCountryRequest) throws WatchMovieException;

	void deleteCountry(DeleteCountryRequest deleteCountryRequest);
}
