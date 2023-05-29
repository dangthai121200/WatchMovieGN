package watch.movie.gn.entity;

import java.util.Date;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import watch.movie.gn.util.ContainsDatabase;
import watch.movie.gn.util.MovieStatus;

@Getter
@Setter
@Entity(name = ContainsDatabase.TABLE_MOVIE)
@Table(name = ContainsDatabase.TABLE_MOVIE)
public class Movie extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3034941778917542234L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = ContainsDatabase.COLUMN_MOVIE_PK_ID_MOVIE, length = 10)
	private int pkIdMovie;

	@Column(name = ContainsDatabase.COLUMN_MOVIE_NAME, length = 255, unique = true, nullable = false)
	private String name;

	@Column(name = ContainsDatabase.COLUMN_MOVIE_VIEW, length = 10, nullable = true)
	@ColumnDefault(value = "0")
	private int view;

	@Column(name = ContainsDatabase.COLUMN_MOVIE_YEAR_OF_BROADCAST, nullable = true)
	private Date yearOfBroadcast;

	@Column(name = ContainsDatabase.COLUMN_MOVIE_URL_IMAGE, length = 255, nullable = true)
	private String urlImage;

	@Column(name = ContainsDatabase.COLUMN_MOVIE_CONTENT, nullable = true, columnDefinition = "TEXT")
	private String content;

	@Enumerated(EnumType.STRING)
	@Column(name = ContainsDatabase.COLUMN_MOVIE_STATUS, nullable = false, length = 10)
	private MovieStatus status = MovieStatus.NEW;

	@Column(name = ContainsDatabase.COLUMN_MOVIE_TIME, nullable = false, length = 5)
	private Integer time;

	@Column(name = ContainsDatabase.COLUMN_MOVIE_FK_ID_COUNTRY, length = 10, nullable = true, insertable = false, updatable = false)
	private Integer fkIdCountry;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = ContainsDatabase.COLUMN_MOVIE_FK_ID_COUNTRY, referencedColumnName = ContainsDatabase.COLUMN_COUNTRY_PK_ID_COUNTRY, foreignKey = @ForeignKey(name = ContainsDatabase.FOREIGN_MOVIE_FK_ID_COUNTRY))
	private Country country;

	@Column(name = ContainsDatabase.COLUMN_MOVIE_FK_ID_PRODUCER, length = 10, nullable = true, insertable = false, updatable = false)
	private Integer fkIdProducer;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = ContainsDatabase.COLUMN_MOVIE_FK_ID_PRODUCER, referencedColumnName = ContainsDatabase.COLUMN_PRODUCER_PK_ID_PRODUCER, foreignKey = @ForeignKey(name = ContainsDatabase.FOREIGN_MOVIE_FK_ID_PRODUCER))
	private Producer producer;

	@Column(name = ContainsDatabase.COLUMN_MOVIE_FK_ID_SEASON, length = 10, nullable = true, insertable = false, updatable = false)
	private Integer fkIdSeason;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = ContainsDatabase.COLUMN_MOVIE_FK_ID_SEASON, referencedColumnName = ContainsDatabase.COLUMN_SEASON_PK_ID_SEASON, foreignKey = @ForeignKey(name = ContainsDatabase.FOREIGN_MOVIE_FK_ID_SEASON))
	private Season season;

}
