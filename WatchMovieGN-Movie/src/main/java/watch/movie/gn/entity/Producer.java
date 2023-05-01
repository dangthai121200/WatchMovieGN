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

@Table(name = ContainsDatabase.TABLE_PRODUCER)
@Entity(name = ContainsDatabase.TABLE_PRODUCER)
public class Producer extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = ContainsDatabase.COLUMN_PRODUCER_PK_ID_PRODUCER, length = 10)
	private int pkIdProducer;

	@Column(name = ContainsDatabase.COLUMN_PRODUCER_NAME, nullable = false, unique = true, length = 255)
	private String name;

	@OneToMany(mappedBy = ContainsDatabase.TABLE_PRODUCER, fetch = FetchType.LAZY)
	private List<Movie> movies;
}
