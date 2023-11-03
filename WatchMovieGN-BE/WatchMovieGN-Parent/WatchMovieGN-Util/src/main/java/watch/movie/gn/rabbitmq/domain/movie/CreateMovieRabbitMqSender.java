package watch.movie.gn.rabbitmq.domain.movie;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import watch.movie.gn.domain.movie.MovieDomain;

@Data
public class CreateMovieRabbitMqSender implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4876157963231969866L;

	private List<MovieDomain> movies;

}
