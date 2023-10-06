package watch.movie.gn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import watch.movie.gn.domain.LoginReponse;
import watch.movie.gn.domain.LoginRequest;
import watch.movie.gn.service.AccountService;
import watch.movie.gn.util.UrlUtil;

@RestController
@RequestMapping(UrlUtil.ACCOUNT_CONTROLLER_V1)
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping(UrlUtil.ACCOUNT_CONTROLLER_V1_LOGIN)
    public LoginReponse login(LoginRequest loginRequest) {
       return  accountService.login(loginRequest);
    }
}
