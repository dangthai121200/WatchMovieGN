package watch.movie.gn.rabbitmq.receive;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class WatchMovieGnReceiveMovie {

//	@RabbitListener(bindings = @QueueBinding(value = @Queue(value = "myQueue", durable = "true"), 
//			exchange = @Exchange(value = "auto.exch", ignoreDeclarationExceptions = "true"), key = "orderRoutingKey"))
//	public void processOrder(String a) {
//		
//	}

	@RabbitListener(queues = "myqueue")
	public void processOrder(String a) {
		System.out.println(a);
	}

}
