package watch.movie.gn.domain;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
