package watch.movie.gn.service;

import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

public interface TestService {
	void fakeDataMovie() throws StreamReadException, DatabindException, IOException;

}
