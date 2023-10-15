package watch.movie.gn.domain.movie;

import java.util.Date;

import lombok.Data;
import watch.movie.gn.enums.MovieStatusEnums;

@Data
public class CreateMovieRequest {

	private String name;
	private int view;
	private Date yearOfBroadcast;
	private String urlImage;
	private String content;
	private MovieStatusEnums status = MovieStatusEnums.NEW;
	private Integer time;
	private Integer fkIdCountry;
	private Integer fkIdProducer;
	private Integer fkIdSeason;
}
