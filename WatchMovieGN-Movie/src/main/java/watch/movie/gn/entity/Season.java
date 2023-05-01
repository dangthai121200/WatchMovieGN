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
import watch.movie.gn.util.ContainsDatabase;

@Table(name = ContainsDatabase.TABLE_SEASON)
@Entity(name = ContainsDatabase.TABLE_SEASON)
public class Season extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = ContainsDatabase.COLUMN_SEASON_PK_ID_SEASON, length = 10)
	private int pkIdSeason;

	@Column(name = ContainsDatabase.COLUMN_SEASON_NAME, nullable = false, unique = true, length = 255)
	private String name;

	@OneToMany(mappedBy = ContainsDatabase.TABLE_SEASON, fetch = FetchType.LAZY)
	private List<Movie> movies;

}
