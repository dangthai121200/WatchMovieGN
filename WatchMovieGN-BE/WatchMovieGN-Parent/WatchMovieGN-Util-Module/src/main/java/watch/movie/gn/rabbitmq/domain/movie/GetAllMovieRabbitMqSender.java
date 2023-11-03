package watch.movie.gn.rabbitmq.domain.movie;

import java.io.Serializable;

import lombok.Data;

@Data
public class GetAllMovieRabbitMqSender implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9206471195311215369L;
	private Integer page;
	private Integer size;
}
