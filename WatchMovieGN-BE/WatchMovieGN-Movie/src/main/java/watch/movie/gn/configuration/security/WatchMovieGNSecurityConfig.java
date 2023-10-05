package watch.movie.gn.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import watch.movie.gn.enums.RoleEnum;
import watch.movie.gn.util.ProfileActive;
import watch.movie.gn.util.UrlUtil;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class WatchMovieGNSecurityConfig {

	@Bean
	@Profile(ProfileActive.PROFILE_DEV)
	public UserDetailsService userDetailsService() {
		// @formatter:off
		UserDetails user = User.withDefaultPasswordEncoder()
				.username("watchmoviegndev")
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
						.anyRequest().authenticated()
				)
				.httpBasic(withDefaults())
				.formLogin(withDefaults());
		// @formatter:on
		return http.build();
	}

}
