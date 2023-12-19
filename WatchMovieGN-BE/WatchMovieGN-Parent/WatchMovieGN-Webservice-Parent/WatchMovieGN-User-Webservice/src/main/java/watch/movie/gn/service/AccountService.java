package watch.movie.gn.service;

import org.springframework.security.core.Authentication;
import watch.movie.gn.domain.account.LoginReponse;
import watch.movie.gn.rabbitmq.domain.user.AuthenticationUserRabbitMqReponse;
import watch.movie.gn.rabbitmq.domain.user.AuthenticationUserRabbitMqSender;
import watch.movie.gn.security.userdetails.AccountDetails;

public interface AccountService {
	AccountDetails authenticationUser(AuthenticationUserRabbitMqSender authenticationUserRabbitMqSender);

}
