package watch.movie.gn.domain.movie;

import org.springframework.data.domain.Page;

import lombok.Data;

@Data
public class GetAllMovieReponse {
	private Page<MovieDomain> movies;
}
