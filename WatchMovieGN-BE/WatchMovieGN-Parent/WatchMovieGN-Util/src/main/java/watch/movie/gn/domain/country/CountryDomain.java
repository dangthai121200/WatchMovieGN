package watch.movie.gn.domain.country;

import java.io.Serializable;

import lombok.Data;

@Data
public class CountryDomain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7598497752051784508L;
	
	private Integer pkIdCountry;
	private String name;
	private String code;

}
