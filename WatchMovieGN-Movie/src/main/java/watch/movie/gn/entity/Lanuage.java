package watch.movie.gn.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "Lanuage")
@Entity(name = "Lanuage")
public class Lanuage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_ID_LANUAGE", length = 10)
	private int pkIdLanuage;

	@Column(name = "NAME", nullable = false, unique = true, length = 255)
	private String name;

	public Lanuage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPkIdLanuage() {
		return pkIdLanuage;
	}

	public void setPkIdLanuage(int pkIdLanuage) {
		this.pkIdLanuage = pkIdLanuage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
