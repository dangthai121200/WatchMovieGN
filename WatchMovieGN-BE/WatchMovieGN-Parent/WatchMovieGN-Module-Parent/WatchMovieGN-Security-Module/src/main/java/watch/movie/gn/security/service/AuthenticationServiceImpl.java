package watch.movie.gn.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import watch.movie.gn.rabbitmq.sender.WatchMovieGnSenderUser;
import watch.movie.gn.security.domain.GenerateTokenReponse;
import watch.movie.gn.security.domain.GenerateTokenRequest;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private WatchMovieGnSenderUser watchMovieGnSenderUser;

    @Override
    public GenerateTokenReponse generateToken(final GenerateTokenRequest generateTokenRequest) {
        return null;
    }
}
