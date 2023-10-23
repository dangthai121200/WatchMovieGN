//package watch.movie.gn.configuration.security;
//
//import java.security.interfaces.RSAPrivateKey;
//import java.security.interfaces.RSAPublicKey;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.oauth2.jwt.JwtDecoder;
//import org.springframework.security.oauth2.jwt.JwtEncoder;
//import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
//import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
//import org.springframework.security.oauth2.server.resource.web.BearerTokenAuthenticationEntryPoint;
//import org.springframework.security.oauth2.server.resource.web.access.BearerTokenAccessDeniedHandler;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//import com.nimbusds.jose.jwk.JWK;
//import com.nimbusds.jose.jwk.JWKSet;
//import com.nimbusds.jose.jwk.RSAKey;
//import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
//import com.nimbusds.jose.jwk.source.JWKSource;
//import com.nimbusds.jose.proc.SecurityContext;
//
//import watch.movie.gn.enums.RoleEnum;
//import watch.movie.gn.util.ProfileActive;
//import watch.movie.gn.util.UrlUtil;
//
//@Configuration
//@EnableWebSecurity
//public class WatchMovieGNSecurityConfig {
//
//	// @Value("${jwt.public.key}")
//	private RSAPublicKey publicKey;
//
//	// @Value("${jwt.private.key}")
//	private RSAPrivateKey privateKey;
//
//	@Autowired
//
//	@Bean
//	@Qualifier("userDetailsServiceDev")
//	@Profile(ProfileActive.PROFILE_DEV)
//	public UserDetailsService userDetailsServiceDev() {
//		// @formatter:off
//		UserDetails user = User.withUsername("watchmoviegndev")
//				.password("watchmoviegndev")
//				.passwordEncoder(s -> noOpPasswordEncoder().encode(s))
//				.roles(RoleEnum.ADMIN.getName())
//				.build();
//		return new InMemoryUserDetailsManager(user);
//	}
//	// @formatter:on
//
//	@Bean
//	@Profile(ProfileActive.PROFILE_DEV)
//	public PasswordEncoder noOpPasswordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}
//
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		// @formatter:off
//		http
//				.authorizeHttpRequests((authorize) -> authorize
//						.requestMatchers(UrlUtil.MOVIE_CONTROLLER_V1 + UrlUtil.FINALLY_SLASH_URL).permitAll()
//						.requestMatchers(HttpMethod.POST, UrlUtil.MOVIE_CONTROLLER_V1 + UrlUtil.MOVIE_CONTROLLER_V1_GET_ALL_MOVIE).hasRole(RoleEnum.ADMIN.getName())
//						.requestMatchers(HttpMethod.PUT, UrlUtil.MOVIE_CONTROLLER_V1 + UrlUtil.MOVIE_CONTROLLER_V1_GET_ALL_MOVIE).hasRole(RoleEnum.ADMIN.getName())
//						.anyRequest().authenticated()
//				)
//				.oauth2ResourceServer((oauth2) -> oauth2
//						.jwt(jwt -> jwt.decoder(jwtDecoder()))
//				)
//				.httpBasic(Customizer.withDefaults())
//				.formLogin(Customizer.withDefaults())
//				.csrf((csrf) -> csrf.ignoringRequestMatchers(UrlUtil.ACCOUNT_CONTROLLER_V1 + UrlUtil.ACCOUNT_CONTROLLER_V1_GET_TOKEN))
//				.sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//				.exceptionHandling((exceptions) -> exceptions
//						.authenticationEntryPoint(new BearerTokenAuthenticationEntryPoint())
//						.accessDeniedHandler(new BearerTokenAccessDeniedHandler()));
//		// @formatter:on
//		return http.build();
//	}
//
//	@Bean
//	public JwtDecoder jwtDecoder() {
//		return NimbusJwtDecoder.withPublicKey(this.publicKey).build();
//	}
//
//	@Bean
//	public JwtEncoder jwtEncoder() {
//		JWK jwk = new RSAKey.Builder(this.publicKey).privateKey(this.privateKey).build();
//		JWKSource<SecurityContext> jwks = new ImmutableJWKSet<>(new JWKSet(jwk));
//		return new NimbusJwtEncoder(jwks);
//	}
//}
