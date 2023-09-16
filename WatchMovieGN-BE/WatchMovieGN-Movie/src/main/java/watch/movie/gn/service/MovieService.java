package watch.movie.gn.service;

import watch.movie.gn.domain.CreateMovieRequest;
import watch.movie.gn.domain.GetAllMovieReponse;
import watch.movie.gn.domain.GetAllMovieRequest;
import watch.movie.gn.domain.UpdateMovieRequest;
import watch.movie.gn.exception.WatchMovieException;

public interface MovieService {

	GetAllMovieReponse getAllMovie(GetAllMovieRequest getAllMovieRequest);

	void createMovie(CreateMovieRequest createMovieRequest);

	void pullMovie();

	void updateMovie(UpdateMovieRequest updateMovieRequest) throws WatchMovieException;

}
