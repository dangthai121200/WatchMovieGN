package watch.movie.gn.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import watch.movie.gn.enums.RoleEnum;
import watch.movie.gn.util.ProfileActive;
import watch.movie.gn.util.UrlUtil;

@Configuration
@EnableWebSecurity
public class WatchMovieGNSecurityConfig {

	@Bean
	@Profile(ProfileActive.PROFILE_DEV)
	public UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.withUsername("watchmoviegndev").password("watchmoviegndev")
				.authorities(RoleEnum.ADMIN.getName()).build());
		return manager;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().requestMatchers("/**").permitAll()
		.and().httpBasic()
		.and().formLogin();
		
		
		return http.build();
	}

}
