package watch.movie.gn.service;

import watch.movie.gn.domain.LoginReponse;
import watch.movie.gn.domain.LoginRequest;

public interface AccountService {
    LoginReponse login(LoginRequest loginRequest);
}
