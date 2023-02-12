package watch.movie.gn.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "Country")
@Entity(name = "Country")
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_ID_COUNTRY", length = 10)
	private int pkIdCountry;

	@Column(name = "NAME", nullable = false, unique = true, length = 255)
	private String name;

	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPkIdCountry() {
		return pkIdCountry;
	}

	public void setPkIdCountry(int pkIdCountry) {
		this.pkIdCountry = pkIdCountry;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
