package watch.movie.gn.util;

public class ForeignKeyDatabaseSql {
	
	private ForeignKeyDatabaseSql() {

	}

	public static final String GET_ALL_INFORMATION_FOREIGN_TABLE_MOVIE = "SELECT * FROM "
			+ ConstantDatabase.INFORMATION_SCHEMA + "." + ConstantDatabase.INFORMATION_SCHEMA_REFERENTIAL_CONSTRAINTS
			+ " WHERE " + ConstantDatabase.COLUMN_REFERENTIAL_CONSTRAINT_SCHEMA + " = '" + ConstantDatabase.SCHEMA + "'"
			+ " AND " + ConstantDatabase.COLUMN_REFERENTIAL_TABLE_NAME + " = " + "'" + ConstantDatabase.TABLE_MOVIE
			+ "'";
	
	//FK table movie
	public static final String UPDATE_FORGEIGN_MOVIE_FK_ID_COUNTRY = "ALTER TABLE " + ConstantDatabase.TABLE_MOVIE
			+ " ADD CONSTRAINT " + ConstantDatabase.FOREIGN_MOVIE_FK_ID_COUNTRY
			+ " FOREIGN KEY ("+ ConstantDatabase.FOREIGN_MOVIE_FK_ID_COUNTRY + " ) "
			+ " REFERENCES " + ConstantDatabase.TABLE_COUNTRY +" ( "+ ConstantDatabase.COLUMN_COUNTRY_PK_ID_COUNTRY + " ) ON DELETE SET NULL;";

	public static final String DELETE_FORGEIGN_MOVIE_FK_ID_COUNTRY = "ALTER TABLE " + ConstantDatabase.TABLE_MOVIE
			+ " DROP FOREIGN KEY " + ConstantDatabase.FOREIGN_MOVIE_FK_ID_COUNTRY + ";";

}
