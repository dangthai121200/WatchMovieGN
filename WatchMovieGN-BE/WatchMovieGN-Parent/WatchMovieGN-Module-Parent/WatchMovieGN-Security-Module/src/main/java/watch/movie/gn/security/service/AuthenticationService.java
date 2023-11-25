package watch.movie.gn.security.service;

import watch.movie.gn.security.domain.GenerateTokenReponse;
import watch.movie.gn.security.domain.GenerateTokenRequest;

public interface AuthenticationService {
    GenerateTokenReponse generateToken(GenerateTokenRequest generateTokenRequest);
}
