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
import lombok.Getter;
import lombok.Setter;
import watch.movie.gn.util.ConstantDatabase;

@Getter
@Setter
@Table(name = ConstantDatabase.TABLE_PRODUCER)
@Entity(name = ConstantDatabase.TABLE_PRODUCER)
@AllArgsConstructor
public class Producer extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4520861923552450501L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = ConstantDatabase.COLUMN_PRODUCER_PK_ID_PRODUCER, length = 10)
	private Integer pkIdProducer;

	@Column(name = ConstantDatabase.COLUMN_PRODUCER_NAME, nullable = false, unique = true, length = 255)
	private String name;

	@OneToMany(mappedBy = ConstantDatabase.TABLE_PRODUCER, fetch = FetchType.LAZY)
	private List<Movie> movies;

	public Producer() {

	}
}
