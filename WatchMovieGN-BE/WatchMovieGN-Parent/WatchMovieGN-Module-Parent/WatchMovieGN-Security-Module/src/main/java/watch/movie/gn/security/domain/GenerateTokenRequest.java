package watch.movie.gn.security.domain;

import lombok.Data;
import lombok.Getter;
@Data
public class GenerateTokenRequest {
    private String username;
    private String password;
}
