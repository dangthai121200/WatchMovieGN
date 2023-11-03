package watch.movie.gn.rabbitmq.receive;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import watch.movie.gn.rabbitmq.domain.movie.CreateMovieRabbitMqSender;
import watch.movie.gn.service.MovieDocumentService;

@Configuration
public class WatchMovieGnReceiveMovie {

	@Autowired
	private MovieDocumentService movieDocumentService;

//	@RabbitListener(bindings = @QueueBinding(value = @Queue(value = "myQueue", durable = "true"), 
//			exchange = @Exchange(value = "auto.exch", ignoreDeclarationExceptions = "true"), key = "orderRoutingKey"))
//	public void processOrder(String a) {
//		
//	}
	// @formatter:off
	@RabbitListener(
//			bindings = @QueueBinding(
//					exchange = @Exchange,
//					value = @Queue(value = "createMovieQueue", durable = "true"),
//					key = "")
			queuesToDeclare = {@Queue(value = "createMovie")}
			)
	// @formatter:on
	public void createMovies(CreateMovieRabbitMqSender createMovieRabbitMqSender) {
		movieDocumentService.createMovies(createMovieRabbitMqSender);
	}

}
