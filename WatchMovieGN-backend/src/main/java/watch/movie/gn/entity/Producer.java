package watch.movie.gn.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "Producer")
@Entity(name = "Producer")
public class Producer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_ID_PRODUCER", length = 10)
	private int pkIdProducer;

	@Column(name = "NAME", nullable = false, unique = true, length = 255)
	private String name;

	public Producer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPkIdProducer() {
		return pkIdProducer;
	}

	public void setPkIdProducer(int pkIdProducer) {
		this.pkIdProducer = pkIdProducer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
