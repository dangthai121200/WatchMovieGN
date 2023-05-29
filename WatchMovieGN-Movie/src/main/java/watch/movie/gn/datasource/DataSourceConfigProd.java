package watch.movie.gn.datasource;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import watch.movie.gn.util.ProfileActive;

@Component
@Profile(ProfileActive.PROFILE_PROD)
public class DataSourceConfigProd {
	private String URL = "";
	private String USERNAME = "";
	private String PASSWORD = "";
	private String DRIVE_CLASS_NAME = "";

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource(URL, USERNAME, PASSWORD);
		dataSource.setDriverClassName(DRIVE_CLASS_NAME);
		return dataSource;

	}
}
