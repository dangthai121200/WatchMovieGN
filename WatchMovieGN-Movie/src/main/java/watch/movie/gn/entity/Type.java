package watch.movie.gn.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "type")
@Entity(name = "type")
public class Type extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_ID_TYPE", length = 10)
	private int pkIdType;

	@Column(name = "NAME", nullable = false, unique = true, length = 255)
	private String name;
}
