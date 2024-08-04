package watch.movie.gn.service;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

import watch.movie.gn.domain.movie.CreateMovieListRequest;
import watch.movie.gn.domain.movie.MovieDomain;
import watch.movie.gn.entity.Producer;

public interface TestService {
    CreateMovieListRequest fakeDataMovie() throws IOException;

    List<Producer> fakeDataProducers();

}
