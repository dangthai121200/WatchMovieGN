package watch.movie.gn.service;

import java.time.Instant;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import watch.movie.gn.domain.account.LoginReponse;

@Service
public class AccountServiceImpl implements AccountService {

//	@Autowired
	private JwtEncoder encoder;

	@Override
	public LoginReponse createToken(Authentication authentication) {
		LoginReponse loginReponse = new LoginReponse();
		Instant now = Instant.now();
		long expiry = 36000L;
		// @formatter:off
		String scope = authentication.getAuthorities().stream()
				.map(GrantedAuthority::getAuthority)
				.collect(Collectors.joining(" "));
		JwtClaimsSet claims = JwtClaimsSet.builder()
				.issuer("self")
				.issuedAt(now)
				.expiresAt(now.plusSeconds(expiry))
				.subject(authentication.getName())
				.claim("scope", scope)
				.build();
		// @formatter:on
		loginReponse.setJwt(this.encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue());
		return loginReponse;
	}
}
