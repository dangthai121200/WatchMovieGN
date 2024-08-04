package watch.movie.gn.informationschema;

import lombok.Data;
import org.springframework.jdbc.core.RowMapper;
import watch.movie.gn.util.ConstantDatabase;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
public class ReferentialConstraints implements RowMapper<ReferentialConstraints> {
	private String ConstraintCataLog;
	private String ConstraintSchema;
	private String ConstraintName;
	private String UniqueConstraintCataLog;
	private String UniqueConstraintSchema;
	private String UniqueConstraintname;
	private String MatchOption;
	private String UpdateRule;
	private String DeleteRule;
	private String TableName;
	private String ReferencedTableName;

	public ReferentialConstraints(String constraintCataLog, String constraintSchema, String constraintName,
                                  String uniqueConstraintCataLog, String uniqueConstraintSchema, String uniqueConstraintname,
                                  String matchOption, String updateRule, String deleteRule, String tableName, String referencedTableName) {
		super();
		ConstraintCataLog = constraintCataLog;
		ConstraintSchema = constraintSchema;
		ConstraintName = constraintName;
		UniqueConstraintCataLog = uniqueConstraintCataLog;
		UniqueConstraintSchema = uniqueConstraintSchema;
		UniqueConstraintname = uniqueConstraintname;
		MatchOption = matchOption;
		UpdateRule = updateRule;
		DeleteRule = deleteRule;
		TableName = tableName;
		ReferencedTableName = referencedTableName;
	}

	public ReferentialConstraints() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ReferentialConstraints mapRow(ResultSet rs, int rowNum) throws SQLException {

		return new ReferentialConstraints(
				rs.getString(ConstantDatabase.COLUMN_REFERENTIAL_CONSTRAINTS_CONSTRAINT_CATALOG),
				rs.getString(ConstantDatabase.COLUMN_REFERENTIAL_CONSTRAINT_SCHEMA),
				rs.getString(ConstantDatabase.COLUMN_REFERENTIAL_CONSTRAINT_NAME),
				rs.getString(ConstantDatabase.COLUMN_REFERENTIAL_UNIQUE_CONSTRAINT_CATALOG),
				rs.getString(ConstantDatabase.COLUMN_REFERENTIAL_UNIQUE_CONSTRAINT_SCHEMA),
				rs.getString(ConstantDatabase.COLUMN_REFERENTIAL_UNIQUE_CONSTRAINT_NAME),
				rs.getString(ConstantDatabase.COLUMN_REFERENTIAL_MATCH_OPTION),
				rs.getString(ConstantDatabase.COLUMN_REFERENTIAL_UPDATE_RULE),
				rs.getString(ConstantDatabase.COLUMN_REFERENTIAL_DELETE_RULE),
				rs.getString(ConstantDatabase.COLUMN_REFERENTIAL_TABLE_NAME),
				rs.getString(ConstantDatabase.COLUMN_REFERENTIAL_REFERENCED_TABLE_NAME));
	}

}
