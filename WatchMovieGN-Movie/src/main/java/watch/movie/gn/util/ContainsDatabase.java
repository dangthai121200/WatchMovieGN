package watch.movie.gn.util;

public class ContainsDatabase {

	// Schema
	public static final String SCHEMA = "watchmoviegn";

	public static final String INFORMATION_SCHEMA = "information_schema";
	
	// Base entity
	public static final String BASE_ENTITY_COLUMN_DATE_CREATE = "date_create";
	public static final String BASE_ENTITY_COLUMN_DATE_UPDATE = "date_update";

	// REFERENTIAL_CONSTRAINTS
	public static final String INFORMATION_SCHEMA_REFERENTIAL_CONSTRAINTS = "REFERENTIAL_CONSTRAINTS";

	public static final String COLUMN_REFERENTIAL_CONSTRAINTS_CONSTRAINT_CATALOG = "CONSTRAINT_CATALOG";
	public static final String COLUMN_REFERENTIAL_CONSTRAINT_SCHEMA = "CONSTRAINT_SCHEMA";
	public static final String COLUMN_REFERENTIAL_CONSTRAINT_NAME = "CONSTRAINT_NAME";
	public static final String COLUMN_REFERENTIAL_UNIQUE_CONSTRAINT_CATALOG = "UNIQUE_CONSTRAINT_CATALOG";
	public static final String COLUMN_REFERENTIAL_UNIQUE_CONSTRAINT_SCHEMA = "UNIQUE_CONSTRAINT_SCHEMA";
	public static final String COLUMN_REFERENTIAL_UNIQUE_CONSTRAINT_NAME = "UNIQUE_CONSTRAINT_NAME";
	public static final String COLUMN_REFERENTIAL_MATCH_OPTION = "MATCH_OPTION";
	public static final String COLUMN_REFERENTIAL_UPDATE_RULE = "UPDATE_RULE";
	public static final String COLUMN_REFERENTIAL_DELETE_RULE = "DELETE_RULE";
	public static final String COLUMN_REFERENTIAL_TABLE_NAME = "TABLE_NAME";
	public static final String COLUMN_REFERENTIAL_REFERENCED_TABLE_NAME = "REFERENCED_TABLE_NAME";

	// Table movie

	public static final String TABLE_MOVIE = "movie";

	public static final String COLUMN_MOVIE_PK_ID_MOVIE = "PK_ID_MOVIE";

	public static final String COLUMN_MOVIE_NAME = "NAME";
	public static final String COLUMN_MOVIE_VIEW = "VIEW";
	public static final String COLUMN_MOVIE_YEAR_OF_BROADCAST = "YEAR_OF_BROADCAST";

	public static final String COLUMN_MOVIE_FK_ID_COUNTRY = "FK_ID_COUNTRY";
	public static final String COLUMN_MOVIE_FK_ID_PRODUCER = "FK_ID_PRODUCER";
	public static final String COLUMN_MOVIE_FK_ID_SEASON = "FK_ID_SEASON";

	public static final String FOREIGN_MOVIE_FK_ID_COUNTRY = "FK_ID_COUNTRY";
	public static final String FOREIGN_MOVIE_FK_ID_PRODUCER = "FK_ID_PRODUCER";
	public static final String FOREIGN_MOVIE_FK_ID_SEASON = "FK_ID_SEASON";

	// Table country

	public static final String TABLE_COUNTRY = "country";

	public static final String COLUMN_COUNTRY_PK_ID_COUNTRY = "PK_ID_COUNTRY";

	public static final String COLUMN_COUNTRY_CODE = "CODE";
	public static final String COLUMN_COUNTRY_NAME = "NAME";

	// Table producer

	public static final String TABLE_PRODUCER = "producer";

	public static final String COLUMN_PRODUCER_PK_ID_PRODUCER = "PK_ID_PRODUCER";
	public static final String COLUMN_PRODUCER_NAME = "NAME";

	// Table season

	public static final String TABLE_SEASON = "season";

	public static final String COLUMN_SEASON_PK_ID_SEASON = "PK_ID_SEASON";
	public static final String COLUMN_SEASON_NAME = "NAME";

	// Action for foreign key
	public static final String ACTION_FOREIGN_MOVIE_FK_ID_COUNTRY = "FOREIGN KEY (" + COLUMN_MOVIE_FK_ID_COUNTRY
			+ ") REFERENCES " + TABLE_COUNTRY + "(" + COLUMN_COUNTRY_PK_ID_COUNTRY + ")" + " ON DELETE SET NULL ";

	public static final String ACTION_FOREIGN_MOVIE_FK_ID_PRODUCER = "FOREIGN KEY (" + COLUMN_MOVIE_FK_ID_PRODUCER
			+ ") REFERENCES " + TABLE_PRODUCER + "(" + COLUMN_PRODUCER_PK_ID_PRODUCER + ")" + " ON DELETE SET NULL ";

	public static final String ACTION_FOREIGN_MOVIE_FK_ID_SEASON = "FOREIGN KEY (" + FOREIGN_MOVIE_FK_ID_SEASON
			+ ") REFERENCES " + TABLE_SEASON + "(" + COLUMN_SEASON_PK_ID_SEASON + ")" + " ON DELETE SET NULL ";

}
