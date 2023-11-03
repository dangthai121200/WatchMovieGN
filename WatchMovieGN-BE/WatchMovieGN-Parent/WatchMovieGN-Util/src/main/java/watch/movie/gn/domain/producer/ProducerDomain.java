package watch.movie.gn.domain.producer;

import java.io.Serializable;

import lombok.Data;

@Data
public class ProducerDomain implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1229175944282768301L;

	private int pkIdProducer;
	private String name;
}
