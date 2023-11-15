package watch.movie.gn.datasource;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import watch.movie.gn.util.ProfileActive;

@Configuration
@Profile(ProfileActive.PROFILE_DEV)
public class DataSourceConfigDev {

	private String URL = "jdbc:mysql://localhost:3306/watchmoviegn-movie?createDatabaseIfNotExist=true";
	private String USERNAME = "root";
	private String PASSWORD = "";
	private String DRIVE_CLASS_NAME = "com.mysql.cj.jdbc.Driver";

	@Bean
	DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource(URL, USERNAME, PASSWORD);
		dataSource.setDriverClassName(DRIVE_CLASS_NAME);
		return dataSource;

	}

}
