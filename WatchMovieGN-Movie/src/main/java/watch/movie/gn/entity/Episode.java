package watch.movie.gn.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "Episode")
@Entity(name = "Episode")
public class Episode {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_ID_EPISODE", length = 10)
	private int pkIdEpisode;

	@Column(name = "EPISODE", nullable = false, length = 10)
	private int episode;

	@Column(name = "LINK", nullable = false, unique = true, length = 255)
	private String link;

	public Episode() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPkIdEpisode() {
		return pkIdEpisode;
	}

	public void setPkIdEpisode(int pkIdEpisode) {
		this.pkIdEpisode = pkIdEpisode;
	}

	public int getEpisode() {
		return episode;
	}

	public void setEpisode(int episode) {
		this.episode = episode;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

}
