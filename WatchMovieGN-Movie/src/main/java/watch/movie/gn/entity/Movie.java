package watch.movie.gn.entity;

import java.util.Date;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity(name = "movie")
@Table(name = "movie")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_ID_MOVIE", length = 10)
	private int pkIdMovie;

	@Column(name = "NAME", length = 255, unique = true, nullable = false)
	private String name;

	@Column(name = "YEAR_OF_BROADCAST", nullable = true)
	private Date yearOfBroadcast;

	@Column(name = "VIEW", length = 10, nullable = true)
	@ColumnDefault(value = "0")
	private int view;

	@Column(name = "FK_ID_COUNTRY", length = 10, nullable = true, insertable = false, updatable = false)
	private int fkIdCountry;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FK_ID_COUNTRY", referencedColumnName = "PK_ID_COUNTRY", foreignKey = @ForeignKey(name = "FK_ID_COUNTRY"))
	private Country country;

	@Column(name = "FK_ID_SEASON", length = 10, nullable = true, insertable = false, updatable = false)
	private int fkIdSeason;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FK_ID_SEASON", referencedColumnName = "PK_ID_SEASON", foreignKey = @ForeignKey(name = "FK_ID_SEASON"))
	private Season season;

	@Column(name = "FK_ID_PRODUCER", length = 10, nullable = true, insertable = false, updatable = false)
	private int fkIdProducer;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FK_ID_PRODUCER", referencedColumnName = "PK_ID_PRODUCER", foreignKey = @ForeignKey(name = "FK_ID_PRODUCER"))
	private Producer producer;

}
