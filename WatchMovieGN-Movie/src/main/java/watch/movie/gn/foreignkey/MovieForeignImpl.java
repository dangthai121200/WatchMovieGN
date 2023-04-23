package watch.movie.gn.foreignkey;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import watch.movie.gn.informationschema.ReferentialConstraints;
import watch.movie.gn.util.ForeignKeyDatabaseSql;

@Service
public class MovieForeignImpl implements MovieForeign {

	@Autowired
	public DataSource dataSource;

	@Autowired
	public JdbcTemplate jdbcTemplate;

	@Override
	public void updateFkIdCountryOptinonDeleteToSetNull() {
		List<ReferentialConstraints> referentialConstraintsList = jdbcTemplate
				.query(ForeignKeyDatabaseSql.GET_ALL_INFORMATION_FOREIGN_TABLE_MOVIE, new ReferentialConstraints());
		for (ReferentialConstraints referentialConstraints : referentialConstraintsList) {
			if(!referentialConstraints.getDeleteRule().equals("SET NULL")) {
				
			}
		}
	}

}
