package watch.movie.gn.domain.movie;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class GetAllMovieRequest {
	private Integer page;
	private Integer size;

}
