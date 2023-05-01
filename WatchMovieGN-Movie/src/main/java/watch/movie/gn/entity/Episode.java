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
@Table(name = "Episode")
@Entity(name = "Episode")
public class Episode extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_ID_EPISODE", length = 10)
	private int pkIdEpisode;

	@Column(name = "EPISODE", nullable = false, length = 10)
	private int episode;

	@Column(name = "LINK", nullable = false, unique = true, length = 255)
	private String link;

}
