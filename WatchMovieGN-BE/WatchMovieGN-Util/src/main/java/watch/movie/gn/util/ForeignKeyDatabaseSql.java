package watch.movie.gn.util;

public class ForeignKeyDatabaseSql {
	
	private ForeignKeyDatabaseSql() {

	}

	public static final String GET_ALL_INFORMATION_FOREIGN_TABLE_MOVIE = "SELECT * FROM "
			+ ContainsDatabase.INFORMATION_SCHEMA + "." + ContainsDatabase.INFORMATION_SCHEMA_REFERENTIAL_CONSTRAINTS
			+ " WHERE " + ContainsDatabase.COLUMN_REFERENTIAL_CONSTRAINT_SCHEMA + " = '" + ContainsDatabase.SCHEMA + "'"
			+ " AND " + ContainsDatabase.COLUMN_REFERENTIAL_TABLE_NAME + " = " + "'" + ContainsDatabase.TABLE_MOVIE
			+ "'";
	
	//FK table movie
	public static final String UPDATE_FORGEIGN_MOVIE_FK_ID_COUNTRY = "ALTER TABLE " + ContainsDatabase.TABLE_MOVIE 
			+ " ADD CONSTRAINT " + ContainsDatabase.FOREIGN_MOVIE_FK_ID_COUNTRY 
			+ " FOREIGN KEY ("+ ContainsDatabase.FOREIGN_MOVIE_FK_ID_COUNTRY + " ) " 
			+ " REFERENCES " + ContainsDatabase.TABLE_COUNTRY +" ( "+ ContainsDatabase.COLUMN_COUNTRY_PK_ID_COUNTRY + " ) ON DELETE SET NULL;";

	public static final String DELETE_FORGEIGN_MOVIE_FK_ID_COUNTRY = "ALTER TABLE " + ContainsDatabase.TABLE_MOVIE 
			+ " DROP FOREIGN KEY " + ContainsDatabase.FOREIGN_MOVIE_FK_ID_COUNTRY + ";";

}
