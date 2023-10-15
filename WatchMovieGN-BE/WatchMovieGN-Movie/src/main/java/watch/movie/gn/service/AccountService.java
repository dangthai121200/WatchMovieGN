package watch.movie.gn.service;

import org.springframework.security.core.Authentication;

import watch.movie.gn.domain.LoginReponse;

public interface AccountService {
	LoginReponse createToken(Authentication authentication);
}
