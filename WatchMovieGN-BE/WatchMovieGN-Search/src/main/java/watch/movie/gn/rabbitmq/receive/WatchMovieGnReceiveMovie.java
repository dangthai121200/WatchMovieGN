package watch.movie.gn.rabbitmq.receive;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import watch.movie.gn.rabbitmq.domain.movie.GetAllMovieRabbitMqReceive;
import watch.movie.gn.rabbitmq.domain.movie.GetAllMovieRabbitMqSender;
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

	@Bean
	Queue myQueue() {
		return new Queue("getAllMovieQueue");
	}

	@RabbitListener(queues = "getAllMovieQueue")
	public GetAllMovieRabbitMqReceive getAllMovie(GetAllMovieRabbitMqSender getAllMovieRabbitMqSender) {
		return movieDocumentService.getAllMovie(getAllMovieRabbitMqSender);
	}

}
