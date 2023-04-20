package watch.movie.gn.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "Type")
@Entity(name = "Type")
public class Type {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_ID_TYPE", length = 10)
	private int pkIdType;

	@Column(name = "NAME", nullable = false, unique = true, length = 255)
	private String name;

	public Type() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPkIdType() {
		return pkIdType;
	}

	public void setPkIdType(int pkIdType) {
		this.pkIdType = pkIdType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
