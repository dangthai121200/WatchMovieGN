package watch.movie.gn.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class GetAllMovieRequest {
	private int page;
	private int size;

}
