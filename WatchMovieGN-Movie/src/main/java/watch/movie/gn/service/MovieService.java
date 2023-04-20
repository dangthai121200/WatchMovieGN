package watch.movie.gn.service;

import watch.movie.gn.domain.CreateMovieRequest;
import watch.movie.gn.domain.GetAllMovieReponse;
import watch.movie.gn.domain.GetAllMovieRequest;
import watch.movie.gn.domain.UpdateMovieRequest;

public interface MovieService {
	
	GetAllMovieReponse getAllMovie(GetAllMovieRequest getAllMovieRequest);
	void createMovie(CreateMovieRequest createMovieRequest);
	void pullMovie();
	void updateMovie(UpdateMovieRequest updateMovieRequest);

}
