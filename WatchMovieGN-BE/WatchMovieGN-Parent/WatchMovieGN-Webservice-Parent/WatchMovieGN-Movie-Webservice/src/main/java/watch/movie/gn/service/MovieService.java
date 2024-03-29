package watch.movie.gn.service;

import watch.movie.gn.domain.movie.CreateMovieRequest;
import watch.movie.gn.domain.movie.GetAllMovieReponse;
import watch.movie.gn.domain.movie.GetAllMovieRequest;
import watch.movie.gn.domain.movie.UpdateMovieRequest;
import watch.movie.gn.exception.WatchMovieException;

public interface MovieService {

	GetAllMovieReponse getAllMovie(GetAllMovieRequest getAllMovieRequest);

	void createMovie(CreateMovieRequest createMovieRequest);

	void pullMovie();

	void updateMovie(UpdateMovieRequest updateMovieRequest) throws WatchMovieException;

}
