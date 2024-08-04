package watch.movie.gn.rabbitmq.receive.authentication;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import watch.movie.gn.service.AccountService;

@Configuration
@Slf4j
public class WatchMovieGnReceiveAuthentication {

    @Autowired
    private Queue authenticationUserQueue;

    @Autowired
    private AccountService accountService;
}
