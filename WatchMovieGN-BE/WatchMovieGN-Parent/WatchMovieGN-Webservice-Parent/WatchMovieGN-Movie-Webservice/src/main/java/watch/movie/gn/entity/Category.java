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
@Table(name = "Category")
@Entity(name = "Category")
public class Category extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4313042742322180028L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_ID_CATEGORY", length = 10)
	private int pkIdCategory;

	@Column(name = "NAME", nullable = false, unique = true, length = 255)
	private String name;

}
