package watch.movie.gn.foreignkey;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import watch.movie.gn.informationschema.ReferentialConstraints;
import watch.movie.gn.util.ConstantDatabase;
import watch.movie.gn.util.ForeignKeyDatabaseSql;

@Service
@Slf4j
public class MovieForeignImpl implements MovieForeign {

	@Autowired
	public DataSource dataSource;

	@Autowired
	public JdbcTemplate jdbcTemplate;

	@Override
	public void updateFkOptinonDeleteToSetNull() {
		List<ReferentialConstraints> referentialConstraintsList = jdbcTemplate
				.query(ForeignKeyDatabaseSql.GET_ALL_INFORMATION_FOREIGN_TABLE_MOVIE, new ReferentialConstraints());
		for (ReferentialConstraints referentialConstraints : referentialConstraintsList) {
			if (!referentialConstraints.getDeleteRule().equals("SET NULL") && referentialConstraints.getConstraintName()
					.equals(ConstantDatabase.FOREIGN_MOVIE_FK_ID_COUNTRY)) {
				deleteFkIdCountry();
				jdbcTemplate.execute(ForeignKeyDatabaseSql.UPDATE_FORGEIGN_MOVIE_FK_ID_COUNTRY);
				log.info("SQL: " + ForeignKeyDatabaseSql.UPDATE_FORGEIGN_MOVIE_FK_ID_COUNTRY);
				log.info("Update foregin key: " + referentialConstraints.getConstraintName());
			}
		}
	}

	@Override
	public void deleteFkIdCountry() {
		jdbcTemplate.execute(ForeignKeyDatabaseSql.DELETE_FORGEIGN_MOVIE_FK_ID_COUNTRY);
		log.info("SQL: " + ForeignKeyDatabaseSql.DELETE_FORGEIGN_MOVIE_FK_ID_COUNTRY);
	}

}
