package watch.movie.gn.rabbitmq;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import watch.movie.gn.util.ProfileActive;

@Configuration
@Profile(ProfileActive.PROFILE_DEV)
public class WatchMovieGnRabbitMqConfigDev {

	private static final String USERNAME = "guest";
	private static final String PASSWORD = "guest";
//	private static final String HOST = "http://localhost";
//	private static final int PORT = 15672;

	@Bean
	ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory(); // use host and port default
		connectionFactory.setUsername(USERNAME);
		connectionFactory.setPassword(PASSWORD);
		return connectionFactory;
	}

	@Bean
	RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
		return rabbitTemplate;
	}
}
