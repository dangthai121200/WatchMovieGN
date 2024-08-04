package watch.movie.gn.domain.movie;

import lombok.Data;

import java.util.List;

@Data
public class CreateMovieListRequest {
    List<CreateMovieRequest> movies;
}
