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
import watch.movie.gn.util.ContainsDatabase;

@Getter
@Setter
@Table(name = ContainsDatabase.TABLE_PRODUCER)
@Entity(name = ContainsDatabase.TABLE_PRODUCER)
@AllArgsConstructor
public class Producer extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4520861923552450501L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = ContainsDatabase.COLUMN_PRODUCER_PK_ID_PRODUCER, length = 10)
	private Integer pkIdProducer;

	@Column(name = ContainsDatabase.COLUMN_PRODUCER_NAME, nullable = false, unique = true, length = 255)
	private String name;

	@OneToMany(mappedBy = ContainsDatabase.TABLE_PRODUCER, fetch = FetchType.LAZY)
	private List<Movie> movies;

}
