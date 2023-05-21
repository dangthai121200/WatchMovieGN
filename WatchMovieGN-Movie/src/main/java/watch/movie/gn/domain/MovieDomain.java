package watch.movie.gn.domain;

import java.util.Date;

import lombok.Data;
import watch.movie.gn.util.MovieStatus;

@Data
public class MovieDomain {
	private int pkIdMovie;
	private String name;
	private Date yearOfBroadcast;
	private int view;
	private String urlImage;
	private MovieStatus status;
	private Integer time;
	private SeasonDomain season;
	private CountryDomain country;
	private ProducerDomain producer;

}
