package watch.movie.gn.util;

public class ForeignKeyDatabaseSql {
	
	public static final String GET_ALL_INFORMATION_FOREIGN_TABLE_MOVIE = "SELECT * FROM "
			+ ContainsDatabase.INFORMATION_SCHEMA + "." + ContainsDatabase.INFORMATION_SCHEMA_REFERENTIAL_CONSTRAINTS
			+ " WHERE " + ContainsDatabase.COLUMN_REFERENTIAL_CONSTRAINT_SCHEMA + " = '" + ContainsDatabase.SCHEMA + "'"
			+ " AND " + ContainsDatabase.COLUMN_REFERENTIAL_TABLE_NAME + " = " + "'" + ContainsDatabase.TABLE_MOVIE
			+ "'";
}
