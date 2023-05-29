package watch.movie.gn.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "type")
@Entity(name = "type")
public class Type extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1303856980307602604L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_ID_TYPE", length = 10)
	private int pkIdType;

	@Column(name = "NAME", nullable = false, unique = true, length = 255)
	private String name;
}
