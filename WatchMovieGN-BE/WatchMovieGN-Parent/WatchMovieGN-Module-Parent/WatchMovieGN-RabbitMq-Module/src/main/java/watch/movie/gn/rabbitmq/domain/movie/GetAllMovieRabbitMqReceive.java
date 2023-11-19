package watch.movie.gn.rabbitmq.domain.movie;

import lombok.Data;
import org.springframework.data.domain.Page;
import watch.movie.gn.domain.movie.MovieDomain;

import java.io.Serializable;

@Data
public class GetAllMovieRabbitMqReceive implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3078772325525306028L;
	private Page<MovieDomain> movies;
}
