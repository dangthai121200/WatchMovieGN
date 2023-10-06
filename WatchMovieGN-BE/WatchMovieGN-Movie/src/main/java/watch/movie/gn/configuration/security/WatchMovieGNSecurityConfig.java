package watch.movie.gn.configuration.security;

import static org.springframework.security.config.Customizer.withDefaults;

import com.nimbusds.jose.JWSAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.DelegatingOAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import watch.movie.gn.enums.RoleEnum;
import watch.movie.gn.util.ProfileActive;
import watch.movie.gn.util.UrlUtil;

import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.interfaces.RSAPublicKey;
import java.time.Duration;
import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class WatchMovieGNSecurityConfig {

	@Bean
	@Qualifier("userDetailsServiceDev")
	@Profile(ProfileActive.PROFILE_DEV)
	public UserDetailsService userDetailsServiceDev() {
		// @formatter:off
		UserDetails user = User.withUsername("watchmoviegndev")
				.password("watchmoviegndev")
				.passwordEncoder(s -> noOpPasswordEncoder().encode(s))
				.roles(RoleEnum.ADMIN.getName())
				.build();
		return new InMemoryUserDetailsManager(user);
	}
	// @formatter:on

	@Bean
	@Profile(ProfileActive.PROFILE_DEV)
	public PasswordEncoder noOpPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		// @formatter:off
		http
				.authorizeHttpRequests((authorize) -> authorize
						.requestMatchers(UrlUtil.MOVIE_CONTROLLER_V1 + UrlUtil.FINALLY_SLASH_URL).permitAll()
						.requestMatchers(HttpMethod.POST, UrlUtil.MOVIE_CONTROLLER_V1 + UrlUtil.MOVIE_CONTROLLER_V1_GET_ALL_MOVIE).hasRole(RoleEnum.ADMIN.getName())
						.requestMatchers(HttpMethod.PUT, UrlUtil.MOVIE_CONTROLLER_V1 + UrlUtil.MOVIE_CONTROLLER_V1_GET_ALL_MOVIE).hasRole(RoleEnum.ADMIN.getName())
						.anyRequest().authenticated()
				)
				.oauth2ResourceServer((oauth2) -> oauth2
						.jwt(jwt -> jwt.decoder(jwtDecoder()))
				)
				.httpBasic(Customizer.withDefaults())
				.formLogin(Customizer.withDefaults())
				.sessionManagement().disable()
				.csrf().disable();
		// @formatter:on
		return http.build();
	}

	@Bean
	public JwtDecoder jwtDecoder() {
		// @formatter:off
		NimbusJwtDecoder jwtDecoder = NimbusJwtDecoder.
				withSecretKey(new SecretKeySpec("watchmoviegn".getBytes(), JWSAlgorithm.RS256.getName()))
				.build();
//		OAuth2TokenValidator<Jwt> withClockSkew = new DelegatingOAuth2TokenValidator<>(
//				new JwtTimestampValidator(Duration.ofSeconds(60)),
//				new JwtIssuerValidator(issuerUri));
//		jwtDecoder.setJwtValidator(withClockSkew);
		return jwtDecoder;
		// @formatter:on
	}

	@Bean
	public JwtEncoder jwtEncoder() {
		NimbusJwtEncoder nimbusJwtEncoder = new NimbusJwtEncoder();
	}
}
