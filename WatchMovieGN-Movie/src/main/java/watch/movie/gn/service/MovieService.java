package watch.movie.gn.service;

import watch.movie.gn.domain.CreateMovieRequest;
import watch.movie.gn.domain.GetAllMovieReponse;
import watch.movie.gn.domain.GetAllMovieRequest;

public interface MovieService {
	
	GetAllMovieReponse getAllMovie(GetAllMovieRequest getAllMovieRequest);
	void createMovie(CreateMovieRequest createMovieRequest);
	void pullMovie();

}
