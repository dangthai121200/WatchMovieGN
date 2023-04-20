package watch.movie.gn.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "Season")
@Entity(name = "Season")
public class Season {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_ID_SEASON", length = 10)
	private int pkIdSeason;

	@Column(name = "NAME", nullable = false, unique = true, length = 255)
	private String name;

	public Season() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPkIdSeason() {
		return pkIdSeason;
	}

	public void setPkIdSeason(int pkIdSeason) {
		this.pkIdSeason = pkIdSeason;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
