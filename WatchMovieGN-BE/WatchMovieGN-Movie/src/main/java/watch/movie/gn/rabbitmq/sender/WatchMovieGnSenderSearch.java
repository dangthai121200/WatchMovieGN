package watch.movie.gn.rabbitmq.sender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import watch.movie.gn.rabbitmq.domain.movie.CreateMovieRabbitMqSender;

@Slf4j
@Component
@Configuration
public class WatchMovieGnSenderSearch {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void createMovies(CreateMovieRabbitMqSender createMovieRabbitMqSender) {
		if (!createMovieRabbitMqSender.getMovies().isEmpty()) {
			log.debug("message = Call RabbitMq createMovie");
			rabbitTemplate.convertAndSend(createMovieRabbitMqSender);
		}
	}

}
