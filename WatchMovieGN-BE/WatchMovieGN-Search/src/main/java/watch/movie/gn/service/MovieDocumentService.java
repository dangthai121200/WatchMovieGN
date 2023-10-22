package watch.movie.gn.service;

import watch.movie.gn.rabbitmq.domain.movie.GetAllMovieRabbitMqReceive;
import watch.movie.gn.rabbitmq.domain.movie.GetAllMovieRabbitMqSender;

public interface MovieDocumentService {
	GetAllMovieRabbitMqReceive getAllMovie(GetAllMovieRabbitMqSender getAllMovieRabbitMqSender);
}
