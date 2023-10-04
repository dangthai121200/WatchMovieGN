package watch.movie.gn.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import watch.movie.gn.util.ContainsDatabase;

@Getter
@Setter
@Table(name = ContainsDatabase.TABLE_LANGUAGE)
@Entity(name = ContainsDatabase.TABLE_LANGUAGE)
public class Lanuage extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4588543478997939573L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = ContainsDatabase.COLUMN_LANGUAGE_PK_ID_LANGUAGE, length = 10)
	private int pkIdLanuage;

	@Column(name = ContainsDatabase.COLUMN_LANGUAGE_NAME, nullable = false, unique = true, length = 255)
	private String name;

}
