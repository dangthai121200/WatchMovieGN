package watch.movie.gn.service;

import watch.movie.gn.domain.movie.CreateMovieListRequest;
import watch.movie.gn.domain.movie.GetAllMovieReponse;
import watch.movie.gn.domain.movie.GetAllMovieRequest;
import watch.movie.gn.rabbitmq.domain.movie.CreateMovieRabbitMqSender;

public interface MovieDocumentService {
	GetAllMovieReponse getAllMovie(GetAllMovieRequest getAllMovieRequest);

	void createMovies(CreateMovieRabbitMqSender createMovieRabbitMqSender);

	void createMovies(CreateMovieListRequest createMovieListRequest);

}
