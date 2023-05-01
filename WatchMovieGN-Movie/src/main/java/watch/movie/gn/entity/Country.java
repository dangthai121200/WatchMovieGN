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
import lombok.Getter;
import lombok.Setter;
import watch.movie.gn.util.ContainsDatabase;

@Getter
@Setter
@Table(name = ContainsDatabase.TABLE_COUNTRY)
@Entity(name = ContainsDatabase.TABLE_COUNTRY)
public class Country extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = ContainsDatabase.COLUMN_COUNTRY_PK_ID_COUNTRY, length = 10)
	private Integer pkIdCountry;

	@Column(name = ContainsDatabase.COLUMN_COUNTRY_CODE, nullable = false, unique = true, length = 4)
	private String code;

	@Column(name = ContainsDatabase.COLUMN_COUNTRY_NAME, nullable = false, unique = true, length = 255)
	private String name;

	@OneToMany(mappedBy = ContainsDatabase.TABLE_COUNTRY, fetch = FetchType.LAZY)
	private List<Movie> movies;

}
