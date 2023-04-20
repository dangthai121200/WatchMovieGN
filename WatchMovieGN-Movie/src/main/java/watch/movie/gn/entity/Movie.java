package watch.movie.gn.entity;

import java.util.Date;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity(name = "Movie")
@Table(name = "Movie")
@Data
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

}
