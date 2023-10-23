package watch.movie.gn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import watch.movie.gn.domain.account.LoginReponse;
import watch.movie.gn.service.AccountService;
import watch.movie.gn.util.UrlUtil;

@RestController
@RequestMapping(UrlUtil.ACCOUNT_CONTROLLER_V1)
public class AccountController {

	@Autowired
	private AccountService accountService;

	@PostMapping(UrlUtil.ACCOUNT_CONTROLLER_V1_GET_TOKEN)
	public LoginReponse login(Authentication authentication) {
		return accountService.createToken(authentication);
	}
}
