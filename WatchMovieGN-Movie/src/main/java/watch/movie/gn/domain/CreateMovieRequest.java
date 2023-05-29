package watch.movie.gn.domain;

import java.util.Date;

import lombok.Data;
import watch.movie.gn.util.MovieStatus;

@Data
public class CreateMovieRequest {

	private String name;
	private int view;
	private Date yearOfBroadcast;
	private String urlImage;
	private String content;
	private MovieStatus status = MovieStatus.NEW;
	private Integer time;
	private Integer fkIdCountry;
	private Integer fkIdProducer;
	private Integer fkIdSeason;
}
