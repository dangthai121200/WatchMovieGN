package watch.movie.gn.rabbitmq.receive.movie;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import watch.movie.gn.rabbitmq.util.RabbitMQConstantGlobal;
import watch.movie.gn.rabbitmq.util.RabbitMQUtil;
import watch.movie.gn.util.ConstantGlobal;

@Configuration
public class WatchMovieGnConfigMovie {
    @Bean
    DirectExchange movieCrudDirectExchange() {
        return new DirectExchange(RabbitMQConstantGlobal.SEARCH_SERVICE_MOVIE_CRUD_EXCHANGE);
    }

    @Bean
    Queue createMoviesQueue() {
        return new Queue(RabbitMQConstantGlobal.SEARCH_SERVICE_MOVE_CREATE_QUEUE);
    }

    @Bean
    Binding createMoviesBinding() {
        return BindingBuilder.bind(createMoviesQueue()).to(movieCrudDirectExchange())
                .with(RabbitMQConstantGlobal.SEARCH_SERVICE_MOVIE_CREATE_ROUTING);
    }


}
