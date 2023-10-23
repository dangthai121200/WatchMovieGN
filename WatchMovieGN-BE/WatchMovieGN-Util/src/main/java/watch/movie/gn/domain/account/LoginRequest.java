package watch.movie.gn.domain.account;

import lombok.Data;

@Data
public class LoginRequest {
	private String username;
	private String password;
}
