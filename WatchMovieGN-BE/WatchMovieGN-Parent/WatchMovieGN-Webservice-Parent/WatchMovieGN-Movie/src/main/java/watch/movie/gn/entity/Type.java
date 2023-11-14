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
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import watch.movie.gn.util.ConstantDatabase;

@Getter
@Setter
@AllArgsConstructor
@Table(name = ConstantDatabase.TABLE_TYPE)
@Entity(name = ConstantDatabase.TABLE_TYPE)
public class Type extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1303856980307602604L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = ConstantDatabase.COLUMN_TYPE_PK_ID_TYPE, length = 10)
	private Integer pkIdType;

	@Column(name = ConstantDatabase.COLUMN_TYPE_NAME, nullable = false, unique = true, length = 255)
	private String name;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = ConstantDatabase.TABLE_TYPE)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private List<Movie> movies;

	public Type() {

	}
}
