package watch.movie.gn.datasource;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import watch.movie.gn.util.ProfileActive;

@Configuration
@Profile(ProfileActive.PROFILE_PROD)
public class DataSourceConfigProd {

	private String URL = "jdbc:mysql://localhost:3306/watchmoviegn";
	private String USERNAME = "watchmoviegn";
	private String PASSWORD = "watchmoviegn";
	private String DRIVE_CLASS_NAME = "com.mysql.cj.jdbc.Driver";

    @Bean
    DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource(URL, USERNAME, PASSWORD);
		dataSource.setDriverClassName(DRIVE_CLASS_NAME);
		return dataSource;

	}
}
