package watch.movie.gn.rabbitmq;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.SimplePropertyValueConnectionNameStrategy;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;
import org.springframework.retry.support.RetryTemplate;

import watch.movie.gn.util.ProfileActive;

@Configuration
@Profile(ProfileActive.PROFILE_DEV)
public class WatchMovieGnRabbitMqConfigDev {

	private static final String USERNAME = "guest";
	private static final String PASSWORD = "guest";
//	private static final String HOST = "http://localhost";
//	private static final int PORT = 15672;

	@Value("${spring.application.name}")
	private String applicationName;

	@Bean
	@Qualifier(value = "spring.application.name")
	SimplePropertyValueConnectionNameStrategy simplePropertyValueConnectionNameStrategy() {
		return new SimplePropertyValueConnectionNameStrategy(applicationName);
	}

	@Bean
	ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory(); // use host and port default
		connectionFactory.setUsername(USERNAME);
		connectionFactory.setPassword(PASSWORD);
		connectionFactory.setConnectionNameStrategy(simplePropertyValueConnectionNameStrategy());
		return connectionFactory;
	}

	@Bean
	RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
		RetryTemplate retryTemplate = new RetryTemplate();
		ExponentialBackOffPolicy backOffPolicy = new ExponentialBackOffPolicy();
		backOffPolicy.setInitialInterval(500);
		backOffPolicy.setMultiplier(10.0);
		backOffPolicy.setMaxInterval(10000);
		retryTemplate.setBackOffPolicy(backOffPolicy);
		rabbitTemplate.setRetryTemplate(retryTemplate);
		return rabbitTemplate;
	}

	@Bean
	AmqpAdmin amqpAdmin(ConnectionFactory connectionFactory) {
		AmqpAdmin amqpAdmin = new RabbitAdmin(connectionFactory);
		return amqpAdmin;
	}
}
