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
import watch.movie.gn.util.ConstantDatabase;

@Getter
@Setter
@Table(name = ConstantDatabase.TABLE_COUNTRY)
@Entity(name = ConstantDatabase.TABLE_COUNTRY)
public class Country extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2556807743378934613L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = ConstantDatabase.COLUMN_COUNTRY_PK_ID_COUNTRY, length = 10)
	private Integer pkIdCountry;

	@Column(name = ConstantDatabase.COLUMN_COUNTRY_CODE, nullable = false, unique = true, length = 4)
	private String code;

	@Column(name = ConstantDatabase.COLUMN_COUNTRY_NAME, nullable = false, unique = true, length = 255)
	private String name;

	@OneToMany(mappedBy = ConstantDatabase.TABLE_COUNTRY, fetch = FetchType.LAZY)
	private List<Movie> movies;

}
