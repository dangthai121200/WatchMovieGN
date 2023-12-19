package watch.movie.gn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.stereotype.Service;
import watch.movie.gn.entity.Account;
import watch.movie.gn.rabbitmq.domain.user.AuthenticationUserRabbitMqReponse;
import watch.movie.gn.rabbitmq.domain.user.AuthenticationUserRabbitMqSender;
import watch.movie.gn.repository.AccountRepository;
import watch.movie.gn.security.userdetails.AccountDetails;

import java.util.HashSet;

@Service
public class AccountServiceImpl implements AccountService, UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    //	@Autowired
    private JwtEncoder encoder;

    @Override
    public AccountDetails authenticationUser(AuthenticationUserRabbitMqSender authenticationUserRabbitMqSender) {
        String username = authenticationUserRabbitMqSender.getUsername();
        String password = authenticationUserRabbitMqSender.getPassword();
        AccountDetails accountDetails = (AccountDetails) loadUserByUsername(username);
        if (accountDetails != null && password.equals(authenticationUserRabbitMqSender.getPassword())) {
            return accountDetails;
        }
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username);
        if (account != null) {
            // @formatter:off
            AccountDetails accountDetails = new AccountDetails.AccountDetailsBuilder()
                    .setUsername(account.getUsername())
                    .setPassword(account.getPassword())
                    .setAuthorities(new HashSet<>())
                    .setAccountNonExpired(true)
                    .setAccountNonLocked(true)
                    .setCredentialsNonExpired(true)
                    .setEnabled(true)
                    .build();
            // @formatter:on
            return accountDetails;
        }
        return null;
    }
}
