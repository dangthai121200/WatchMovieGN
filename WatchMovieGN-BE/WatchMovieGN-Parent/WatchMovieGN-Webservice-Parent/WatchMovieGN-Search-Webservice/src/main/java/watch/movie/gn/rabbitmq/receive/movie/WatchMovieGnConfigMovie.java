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
        String queueName = RabbitMQUtil.getQueueName(RabbitMQConstantGlobal.SEARCH_SERVICE,
                RabbitMQConstantGlobal.SEARCH_SERVICE_MOVIE_CREATE_ACTION);
        return new Queue(queueName);
    }

    @Bean
    Binding bindingCreateMovies() {
        return BindingBuilder.bind(createMoviesQueue()).to(movieCrudDirectExchange())
                .with(RabbitMQConstantGlobal.SEARCH_SERVICE_MOVIE_CREATE_ROUTING);
    }


}
