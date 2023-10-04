package watch.movie.gn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableReactiveElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import watch.movie.gn.foreignkey.MovieForeign;
import watch.movie.gn.service.CountryService;
import watch.movie.gn.service.RoleService;
import watch.movie.gn.service.SeasonService;

@EnableReactiveElasticsearchRepositories
@EnableJpaRepositories
@SpringBootApplication
public class WatchMovieGnBackendApplication implements CommandLineRunner {

	@Autowired
	private MovieForeign movieForeign;

	@Autowired
	private CountryService countryService;

	@Autowired
	private SeasonService seasonService;

	@Autowired
	private RoleService roleService;

	public static void main(String[] args) {
		SpringApplication.run(WatchMovieGnBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		checkForeignDatabase();
		updateDataEnumIntoDatabase();
	}

	private void checkForeignDatabase() {
		movieForeign.updateFkOptinonDeleteToSetNull();
	}

	private void updateDataEnumIntoDatabase() {
		countryService.updateCountryEnumsIntoDatabase();
		seasonService.updateSeasonEnumsIntoDatabase();
		roleService.updateRoleEnumsIntoDatabase();
	}

}
