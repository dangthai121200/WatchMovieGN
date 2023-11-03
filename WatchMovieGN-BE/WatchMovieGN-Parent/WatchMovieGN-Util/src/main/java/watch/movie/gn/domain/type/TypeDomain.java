package watch.movie.gn.domain.type;

import java.io.Serializable;

import lombok.Data;

@Data
public class TypeDomain implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8275008646178540352L;
	
	private Integer pkIdType;
	private String name;
}
