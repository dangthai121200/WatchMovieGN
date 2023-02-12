package watch.movie.gn.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "Category")
@Entity(name = "Category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_ID_CATEGORY", length = 10)
	private int pkIdCategory;

	@Column(name = "NAME", nullable = false, unique = true, length = 255)
	private String name;

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPkIdCategory() {
		return pkIdCategory;
	}

	public void setPkIdCategory(int pkIdCategory) {
		this.pkIdCategory = pkIdCategory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
