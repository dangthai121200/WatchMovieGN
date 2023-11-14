package watch.movie.gn.domain.type;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class GetAllMovieTypeDomain  implements Serializable {
    List<MovieTypeDomain> Types = new ArrayList<>();
}
