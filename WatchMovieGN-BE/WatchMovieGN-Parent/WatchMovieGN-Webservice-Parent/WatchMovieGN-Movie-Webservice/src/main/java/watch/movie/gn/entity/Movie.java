package watch.movie.gn.entity;

import java.util.Date;
import java.util.List;

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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import watch.movie.gn.enums.MovieStatusEnums;
import watch.movie.gn.util.ConstantDatabase;

@Getter
@Setter
@Entity(name = ConstantDatabase.TABLE_MOVIE)
@Table(name = ConstantDatabase.TABLE_MOVIE)
public class Movie extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3034941778917542234L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = ConstantDatabase.COLUMN_MOVIE_PK_ID_MOVIE, length = 10)
	private int pkIdMovie;

	@Column(name = ConstantDatabase.COLUMN_MOVIE_NAME, length = 255, unique = true, nullable = false)
	private String name;

	@Column(name = ConstantDatabase.COLUMN_MOVIE_VIEW, length = 10, nullable = true)
	@ColumnDefault(value = "0")
	private int view;

	@Column(name = ConstantDatabase.COLUMN_MOVIE_YEAR_OF_BROADCAST, nullable = true)
	private Date yearOfBroadcast;

	@Column(name = ConstantDatabase.COLUMN_MOVIE_URL_IMAGE, length = 255, nullable = true)
	private String urlImage;

	@Column(name = ConstantDatabase.COLUMN_MOVIE_CONTENT, nullable = true, columnDefinition = "TEXT")
	private String content;

	@Enumerated(EnumType.STRING)
	@Column(name = ConstantDatabase.COLUMN_MOVIE_STATUS, nullable = false, length = 10)
	private MovieStatusEnums status = MovieStatusEnums.NEW;

	@Column(name = ConstantDatabase.COLUMN_MOVIE_TIME, nullable = false, length = 5)
	private Integer time;

	@Column(name = ConstantDatabase.COLUMN_MOVIE_FK_ID_COUNTRY, length = 10, nullable = true, insertable = false, updatable = false)
	private Integer fkIdCountry;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = ConstantDatabase.COLUMN_MOVIE_FK_ID_COUNTRY, referencedColumnName = ConstantDatabase.COLUMN_COUNTRY_PK_ID_COUNTRY, foreignKey = @ForeignKey(name = ConstantDatabase.FOREIGN_MOVIE_FK_ID_COUNTRY))
	private Country country;

	@Column(name = ConstantDatabase.COLUMN_MOVIE_FK_ID_PRODUCER, length = 10, nullable = true, insertable = false, updatable = false)
	private Integer fkIdProducer;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = ConstantDatabase.COLUMN_MOVIE_FK_ID_PRODUCER, referencedColumnName = ConstantDatabase.COLUMN_PRODUCER_PK_ID_PRODUCER, foreignKey = @ForeignKey(name = ConstantDatabase.FOREIGN_MOVIE_FK_ID_PRODUCER))
	private Producer producer;

	@Column(name = ConstantDatabase.COLUMN_MOVIE_FK_ID_SEASON, length = 10, nullable = true, insertable = false, updatable = false)
	private Integer fkIdSeason;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = ConstantDatabase.COLUMN_MOVIE_FK_ID_SEASON, referencedColumnName = ConstantDatabase.COLUMN_SEASON_PK_ID_SEASON, foreignKey = @ForeignKey(name = ConstantDatabase.FOREIGN_MOVIE_FK_ID_SEASON))
	private Season season;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = ConstantDatabase.COLUMN_MOVIE_FK_ID_TYPE, referencedColumnName = ConstantDatabase.COLUMN_TYPE_PK_ID_TYPE, foreignKey = @ForeignKey(name = ConstantDatabase.FOREIGN_MOVIE_FK_ID_TYPE))
	private Type type;

	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = ConstantDatabase.TABLE_MOVIE, fetch = FetchType.LAZY)
	private List<Episode> episodis;

//	@EqualsAndHashCode.Exclude
//	@ToString.Exclude
//	@OneToMany(mappedBy = ContainsDatabase.TABLE_MOVIE, fetch = FetchType.LAZY)
//	private List<Rating> ratings;

}
