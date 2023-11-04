package watch.movie.gn.rabbitmq.sender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import watch.movie.gn.rabbitmq.domain.movie.CreateMovieRabbitMqSender;
import watch.movie.gn.rabbitmq.util.RabbitMQConstant;
import watch.movie.gn.rabbitmq.util.RabbitMQConstantGlobal;
import watch.movie.gn.util.ProfileActive;

@Slf4j
@Component
@Configuration
public class WatchMovieGnSenderSearch {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void createMovies(CreateMovieRabbitMqSender createMovieRabbitMqSender) {
        if (!createMovieRabbitMqSender.getMovies().isEmpty()) {
            log.info("message = Call RabbitMq createMovie");
            // @formatter:off
            rabbitTemplate.convertAndSend(RabbitMQConstantGlobal.SEARCH_SERVICE_MOVIE_CRUD_EXCHANGE,
                    RabbitMQConstantGlobal.SEARCH_SERVICE_MOVIE_CREATE_ROUTING,
                    createMovieRabbitMqSender);
            // @formatter:on
        }
    }

}
