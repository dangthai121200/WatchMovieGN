package watch.movie.gn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import watch.movie.gn.foreignkey.MovieForeign;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class, DataSourceAutoConfiguration.class })
public class WatchMovieGnBackendApplication implements CommandLineRunner {

	@Autowired
	public MovieForeign movieForeign;

	public static void main(String[] args) {
		SpringApplication.run(WatchMovieGnBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		checkForeignDatabase();
	}

	private void checkForeignDatabase() {
		movieForeign.updateFkOptinonDeleteToSetNull();
	}

}
