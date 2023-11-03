package watch.movie.gn.domain.season;

import java.io.Serializable;

import lombok.Data;

@Data
public class SeasonDomain implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1509560285526632772L;

	private int pkIdSeason;
	private String name;
}
