package watch.movie.gn.rabbitmq.domain.movie;

import lombok.Data;
import watch.movie.gn.domain.movie.MovieDomain;

import java.io.Serializable;
import java.util.List;

@Data
public class CreateMovieRabbitMqSender implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4876157963231969866L;

	private List<MovieDomain> movies;

}
