package watch.movie.gn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class WatchMovieGnEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WatchMovieGnEurekaServerApplication.class, args);
	}

}
