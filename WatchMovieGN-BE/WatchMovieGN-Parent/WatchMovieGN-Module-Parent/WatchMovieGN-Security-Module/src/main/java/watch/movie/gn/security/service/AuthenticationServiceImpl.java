package watch.movie.gn.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import watch.movie.gn.rabbitmq.domain.user.AuthenticationUserRabbitMqReponse;
import watch.movie.gn.rabbitmq.domain.user.AuthenticationUserRabbitMqSender;
import watch.movie.gn.rabbitmq.sender.WatchMovieGnSenderUser;
import watch.movie.gn.security.domain.GenerateTokenReponse;
import watch.movie.gn.security.domain.GenerateTokenRequest;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private WatchMovieGnSenderUser watchMovieGnSenderUser;

    @Override
    public GenerateTokenReponse generateToken(final GenerateTokenRequest generateTokenRequest) {
        AuthenticationUserRabbitMqSender authenticationUserRabbitMqSender = new AuthenticationUserRabbitMqSender();
        authenticationUserRabbitMqSender.setUsername(generateTokenRequest.getUsername());
        authenticationUserRabbitMqSender.setPassword(generateTokenRequest.getPassword());
        AuthenticationUserRabbitMqReponse authenticationUserRabbitMqReponse = watchMovieGnSenderUser.authenticationUser(authenticationUserRabbitMqSender);
        return null;
    }
}
