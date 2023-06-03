package watch.movie.gn.service;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

import watch.movie.gn.domain.MovieDomain;
import watch.movie.gn.entity.Country;
import watch.movie.gn.entity.Producer;
import watch.movie.gn.entity.Season;
import watch.movie.gn.entity.Type;

public interface TestService {
	List<MovieDomain> fakeDataMovie() throws StreamReadException, DatabindException, IOException;

	List<Country> fakeDataCountries();

	List<Season> fakeDataSeasons(int yearStart, int yearEnd);

	List<Producer> fakeDataProducers();
	
	List<Type> fakeDataTypes();

}
