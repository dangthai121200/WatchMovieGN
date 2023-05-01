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
@Table(name = "Lanuage")
@Entity(name = "Lanuage")
public class Lanuage extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_ID_LANUAGE", length = 10)
	private int pkIdLanuage;

	@Column(name = "NAME", nullable = false, unique = true, length = 255)
	private String name;

}
