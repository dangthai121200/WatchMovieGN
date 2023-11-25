package watch.movie.gn.rabbitmq.receive.authentication;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import watch.movie.gn.rabbitmq.util.RabbitMQConstantGlobal;
import watch.movie.gn.rabbitmq.util.RabbitMQUtil;

@Configuration
public class WatchMovieGnConfigAuthentication {
    @Bean
    DirectExchange userAuthenticationDirectExchange() {
        return new DirectExchange(RabbitMQConstantGlobal.USER_SERVICE_USER_AUTHENTICATION_EXCHANGE);
    }

    @Bean
    Queue authenticationUserQueue() {
        return new Queue(RabbitMQConstantGlobal.USER_SERVICE_USER_AUTHENTICATION_QUEUE);
    }

    @Bean
    Binding bindingAuthenticationUser() {
        return BindingBuilder.bind(authenticationUserQueue()).to(userAuthenticationDirectExchange())
                .with(RabbitMQConstantGlobal.USER_SERVICE_USER_AUTHENTICATION_ROUTING);
    }
}
