package watch.movie.gn.rabbitmq;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import watch.movie.gn.util.ProfileActive;

@Configuration
@Profile(ProfileActive.PROFILE_PROD)
public class WatchMovieGnRabbitMqConfigProd {

	private static final String USERNAME = "guest";
	private static final String PASSWORD = "guest";
	private static final String HOST = "http://localhost";
	private static final int PORT = 15672;

	@Bean
	ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
		connectionFactory.setUsername(USERNAME);
		connectionFactory.setPassword(PASSWORD);
		connectionFactory.setHost(HOST);
		connectionFactory.setPort(PORT);
		return connectionFactory;
	}

	@Bean
	RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate();
		rabbitTemplate.setConnectionFactory(connectionFactory);
		return rabbitTemplate;
	}
}
