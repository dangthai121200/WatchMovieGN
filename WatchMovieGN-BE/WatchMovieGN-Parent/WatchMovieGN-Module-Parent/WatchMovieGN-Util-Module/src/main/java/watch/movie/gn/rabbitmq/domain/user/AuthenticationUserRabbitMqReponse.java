package watch.movie.gn.rabbitmq.domain.user;

import lombok.Data;
import watch.movie.gn.security.userdetails.AccountDetails;

import java.io.Serializable;

@Data
public class AuthenticationUserRabbitMqReponse implements Serializable {

    private AccountDetails accountDetails;
    private String error;



}
