package watch.movie.gn.domain;

import java.util.Date;

import lombok.Data;

@Data
public class MovieDomain {
	private int pkIdMovie;
	private String name;
	private Date yearOfBroadcast;
	private int view;
}
