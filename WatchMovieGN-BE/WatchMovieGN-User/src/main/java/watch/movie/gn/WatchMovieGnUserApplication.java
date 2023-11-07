package watch.movie.gn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import watch.movie.gn.service.RoleService;

@SpringBootApplication
public class WatchMovieGnUserApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(WatchMovieGnUserApplication.class, args);
	}

	@Autowired
	private RoleService roleService;
	@Override
	public void run(String... args) {
		roleService.updateRoleEnumsIntoDatabase();
	}
}
