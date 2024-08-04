package watch.movie.gn.rabbitmq.sender;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import watch.movie.gn.rabbitmq.util.RabbitMQConstantGlobal;

@Slf4j
@Component
@Configuration
public class WatchMovieGnSenderUser {

    @Autowired
    private RabbitTemplate rabbitTemplate;

}
