package watch.movie.gn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import watch.movie.gn.foreignkey.MovieForeign;
import watch.movie.gn.service.CountryService;
import watch.movie.gn.service.MovieTypeService;
import watch.movie.gn.service.SeasonService;

@EnableJpaRepositories
@EnableDiscoveryClient
@SpringBootApplication (exclude = {SecurityAutoConfiguration.class, ManagementWebSecurityAutoConfiguration.class})
public class WatchMovieGnMovieApplication implements CommandLineRunner {

    @Autowired
    private MovieForeign movieForeign;

    @Autowired
    private CountryService countryService;

    @Autowired
    private SeasonService seasonService;

    @Autowired
    private MovieTypeService movieTypeService;

    public static void main(String[] args) {
        SpringApplication.run(WatchMovieGnMovieApplication.class, args);
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
        movieTypeService.updateMovieTypeEnumsIntoDatabase();
    }

}
