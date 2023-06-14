package watch.movie.gn.elastic.document;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

import lombok.Data;
import watch.movie.gn.util.ContainsElastic;
import watch.movie.gn.util.MovieStatus;
import watch.movie.gn.util.SeasonEnum;

@Data
@Document(indexName = ContainsElastic.INDEX_MOVIE)
@TypeAlias(ContainsElastic.ALIAS_MOVE)
@Setting(sortFields = { "pkIdMovie" }, sortOrders = { Setting.SortOrder.asc })
public class MovieDocument {

	@Id
	@Field(name = ContainsElastic.FIELD_MOVIE_PK_ID_MOVIE, type = FieldType.Integer, storeNullValue = false)
	private int pkIdMovie;

	@Field(name = ContainsElastic.FIELD_MOVIE_NAME, type = FieldType.Text, storeNullValue = false)
	private String name;

	@Field(name = ContainsElastic.FIELD_MOVIE_VIEW, type = FieldType.Integer)
	private int view = 0;

	@Field(name = ContainsElastic.FIELD_MOVIE_YEAR_OF_BROADCAST, format = DateFormat.basic_date, storeNullValue = true)
	private Date yearOfBroadcast;

	@Field(name = ContainsElastic.FIELD_MOVIE_URL_IMAGE, type = FieldType.Text, storeNullValue = true)
	private String urlImage;

	@Field(name = ContainsElastic.FIELD_MOVIE_CONTENT, type = FieldType.Text, storeNullValue = true)
	private String content;

	@Field(name = ContainsElastic.FIELD_MOVIE_STATUS, storeNullValue = false)
	private MovieStatus status;

	@Field(name = ContainsElastic.FIELD_MOVIE_TIME, type = FieldType.Integer, storeNullValue = false)
	private Integer time;

	@Field(name = ContainsElastic.FIELD_MOVIE_COUNTRY, type = FieldType.Object)
	private CountryDocument country;

	@Field(name = ContainsElastic.FIELD_MOVIE_SEASON, type = FieldType.Object)
	private SeasonDocument season;
	
	@Field(name = ContainsElastic.FIELD_MOVIE_PRODUCER, type = FieldType.Object)
	private ProducerDocument producer;
	
	@Field(name = ContainsElastic.FIELD_MOVIE_TYPE, type = FieldType.Object)
	private TypeDocument type;

	@Data
	public static class CountryDocument {
		private Integer pkIdCountry;
		private String name;
		private String code;
	}

	@Data
	public static class SeasonDocument {
		private int pkIdSeason;
		private SeasonEnum name;
		private Integer year;
	}

	@Data
	public static class ProducerDocument {
		private Integer pkIdProducer;
		private String name;

	}
	
	@Data
	public static class TypeDocument {
		private Integer pkIdType;
		private String name;
	}

}
