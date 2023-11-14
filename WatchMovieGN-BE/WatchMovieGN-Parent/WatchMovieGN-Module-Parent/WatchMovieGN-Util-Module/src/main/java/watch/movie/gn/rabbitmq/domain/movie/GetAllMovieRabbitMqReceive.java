package watch.movie.gn.rabbitmq.domain.movie;

import java.io.Serializable;

import org.springframework.data.domain.Page;

import lombok.Data;
import watch.movie.gn.domain.movie.MovieDomain;

@Data
public class GetAllMovieRabbitMqReceive implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3078772325525306028L;
	private Page<MovieDomain> movies;
}
