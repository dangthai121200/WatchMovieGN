package watch.movie.gn.util;

public class ContainsDatabase {

	private ContainsDatabase() {

	}

	// Schema
	public static final String SCHEMA = "watchmoviegn";

	public static final String INFORMATION_SCHEMA = "information_schema";

	// Base entity
	public static final String BASE_ENTITY_COLUMN_DATE_CREATE = "DATE_CREATE";
	public static final String BASE_ENTITY_COLUMN_DATE_UPDATE = "DATE_UPDATE";

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
	public static final String COLUMN_MOVIE_URL_IMAGE = "URL_IMAGE";
	public static final String COLUMN_MOVIE_CONTENT = "CONTENT";
	public static final String COLUMN_MOVIE_STATUS = "STATUS";
	public static final String COLUMN_MOVIE_TIME = "TIME";

	public static final String COLUMN_MOVIE_FK_ID_COUNTRY = "FK_ID_COUNTRY";
	public static final String COLUMN_MOVIE_FK_ID_PRODUCER = "FK_ID_PRODUCER";
	public static final String COLUMN_MOVIE_FK_ID_SEASON = "FK_ID_SEASON";
	public static final String COLUMN_MOVIE_FK_ID_TYPE = "FK_ID_TYPE";

	public static final String FOREIGN_MOVIE_FK_ID_COUNTRY = "FK_ID_COUNTRY";
	public static final String FOREIGN_MOVIE_FK_ID_PRODUCER = "FK_ID_PRODUCER";
	public static final String FOREIGN_MOVIE_FK_ID_SEASON = "FK_ID_SEASON";
	public static final String FOREIGN_MOVIE_FK_ID_TYPE = "FK_ID_TYPE";

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
	public static final String COLUMN_SEASON_YEAR = "YEAR";

	// Table actor
	public static final String TABLE_ACTOR = "actor";

	public static final String COLUMN_ACTOR_PK_ID_ACTOR = "PK_ID_ACTOR";
	public static final String COLUMN_ACTOR_LAST_NAME = "LAST_NAME";
	public static final String COLUMN_ACTOR_FIRST_NAME = "FIRST_NAME";
	public static final String COLUMN_ACTOR_BIRTHDAY = "BIRTHDAY";
	public static final String COLUMN_ACTOR_GENDER = "GENDER";
	public static final String COLUMN_ACTOR_RANK = "RANK";

	// Table episode
	public static final String TABLE_EPISODE = "episode";

	public static final String COLUMN_EPISODE_EPISODE = "EPISODE";
	public static final String COLUMN_EPISODE_LINK = "LINK";
	public static final String COLUMN_EPISODE_FK_ID_MOVIE = "FK_ID_MOVIE";

	public static final String FOREIGN_EPISODE_FK_ID_MOVIE = "FK_ID_MOVIE";

	// Table type
	public static final String TABLE_TYPE = "type";
	public static final String COLUMN_TYPE_PK_ID_TYPE = "PK_ID_TYPE";
	public static final String COLUMN_TYPE_NAME = "NAME";

	// Table rating
	public static final String TABLE_RATING = "rating";

	public static final String COLUMN_RATING_RATING = "RATING";
	public static final String COLUMN_RATING_COMMENT = "COMMENT";
	public static final String COLUMN_RATING_FK_ID_MOVIE = "FK_ID_MOVIE";
	public static final String COLUMN_RATING_FK_ID_USER = "FK_ID_USER";

	public static final String FOREIGN_RATING_FK_ID_MOVIE = "FK_ID_MOVIE";

	// table language
	public static final String TABLE_LANGUAGE = "language";
	public static final String COLUMN_LANGUAGE_PK_ID_LANGUAGE = "PK_ID_LANGUAGE";
	public static final String COLUMN_LANGUAGE_NAME = "NAME";

	// table role
	public static final String TABLE_ROLE = "role";
	public static final String COLUMN_ROLE_PK_ID_ROLE = "PK_ID_ROLE";
	public static final String COLUMN_ROLE_NAME = "NAME";

	// table account
	public static final String TABLE_ACCOUNT = "account";
	public static final String COLUMN_ACCOUNT_PK_ID_ACCOUNT = "PK_ID_ACCOUNT";
	public static final String COLUMN_ACCOUNT_USERNAME = "USERNAME";
	public static final String COLUMN_ACCOUNT_PASSWORD = "PASSWORD";

	// Action for foreign key
	public static final String ACTION_FOREIGN_MOVIE_FK_ID_COUNTRY = "FOREIGN KEY (" + COLUMN_MOVIE_FK_ID_COUNTRY
			+ ") REFERENCES " + TABLE_COUNTRY + "(" + COLUMN_COUNTRY_PK_ID_COUNTRY + ")" + " ON DELETE SET NULL ";

	public static final String ACTION_FOREIGN_MOVIE_FK_ID_PRODUCER = "FOREIGN KEY (" + COLUMN_MOVIE_FK_ID_PRODUCER
			+ ") REFERENCES " + TABLE_PRODUCER + "(" + COLUMN_PRODUCER_PK_ID_PRODUCER + ")" + " ON DELETE SET NULL ";

	public static final String ACTION_FOREIGN_MOVIE_FK_ID_SEASON = "FOREIGN KEY (" + FOREIGN_MOVIE_FK_ID_SEASON
			+ ") REFERENCES " + TABLE_SEASON + "(" + COLUMN_SEASON_PK_ID_SEASON + ")" + " ON DELETE SET NULL ";

}
