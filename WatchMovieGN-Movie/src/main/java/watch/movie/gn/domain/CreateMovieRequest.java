package watch.movie.gn.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateMovieRequest {
	private List<MovieDomain> movies = new ArrayList<>();
}
