package watch.movie.gn.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "season")
@Entity(name = "season")
public class Season {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_ID_SEASON", length = 10)
	private int pkIdSeason;

	@Column(name = "NAME", nullable = false, unique = true, length = 255)
	private String name;
	
	@OneToMany(mappedBy = "season", fetch = FetchType.LAZY)
	private List<Movie> movies;

}
