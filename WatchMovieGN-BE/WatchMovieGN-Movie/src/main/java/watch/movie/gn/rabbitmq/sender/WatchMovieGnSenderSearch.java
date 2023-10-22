package watch.movie.gn.rabbitmq.sender;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import watch.movie.gn.domain.movie.GetAllMovieReponse;
import watch.movie.gn.domain.movie.GetAllMovieRequest;
import watch.movie.gn.rabbitmq.domain.movie.GetAllMovieRabbitMqReceive;
import watch.movie.gn.rabbitmq.domain.movie.GetAllMovieRabbitMqSender;

@Slf4j
@Component
@Configuration
public class WatchMovieGnSenderSearch {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Bean
	Queue getAllMovieQueue() {
		return new Queue("getAllMovieQueue");
	}

	public GetAllMovieReponse getAllMovie(GetAllMovieRequest getAllMovieRequest) {
		log.debug("message = Call RabbitMq getAllMovie");
		GetAllMovieReponse getAllMovieReponse = new GetAllMovieReponse();
		GetAllMovieRabbitMqSender getAllMovieRabbitMqSender = new GetAllMovieRabbitMqSender();
		getAllMovieRabbitMqSender.setPage(getAllMovieRequest.getPage());
		getAllMovieRabbitMqSender.setSize(getAllMovieRequest.getSize());
		GetAllMovieRabbitMqReceive getAllMovieRabbitMqReceive = (GetAllMovieRabbitMqReceive) rabbitTemplate
				.convertSendAndReceive(ExchangeTypes.DIRECT, "getAllMovieQueue", getAllMovieRabbitMqSender);
		getAllMovieReponse.setMovies(getAllMovieRabbitMqReceive.getMovies());
		return getAllMovieReponse;
	}

}
