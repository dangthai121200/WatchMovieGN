package watch.movie.gn.rabbitmq.domain.user;

import lombok.Data;

import java.io.Serializable;

@Data
public class AuthenticationUserRabbitMqSender implements Serializable {
    private String username;
    private String password;
}
