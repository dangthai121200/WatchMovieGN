package watch.movie.gn.datasource;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class DataSourceConfigDev {

	private String URL = "jdbc:mysql://localhost:3306/watchmoviegn";
	private String USERNAME = "watchmoviegn";
	private String PASSWORD = "watchmoviegn";
	private String DRIVE_CLASS_NAME = "com.mysql.cj.jdbc.Driver";

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource(URL, USERNAME, PASSWORD);
		dataSource.setDriverClassName(DRIVE_CLASS_NAME);
		return dataSource;

	}

}
