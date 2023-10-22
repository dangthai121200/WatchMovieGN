package watch.movie.gn;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableReactiveElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import watch.movie.gn.foreignkey.MovieForeign;
import watch.movie.gn.service.CountryService;
import watch.movie.gn.service.RoleService;
import watch.movie.gn.service.SeasonService;

@EnableReactiveElasticsearchRepositories
@EnableJpaRepositories
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class, ManagementWebSecurityAutoConfiguration.class })
public class WatchMovieGnBackendApplication implements CommandLineRunner {

	@Autowired
	private MovieForeign movieForeign;

	@Autowired
	private CountryService countryService;

	@Autowired
	private SeasonService seasonService;

	@Autowired
	private RoleService roleService;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;

	public static void main(String[] args) {
		SpringApplication.run(WatchMovieGnBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//checkForeignDatabase();
		//updateDataEnumIntoDatabase();
		rabbitTemplate.convertAndSend("myqueue", "a");
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
