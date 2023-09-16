package watch.movie.gn.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import watch.movie.gn.util.ContainsDatabase;

@Getter
@Setter
@Table(name = ContainsDatabase.TABLE_EPISODE)
@Entity(name = ContainsDatabase.TABLE_EPISODE)
public class Episode extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3256886363771706573L;

	@EmbeddedId
	private EpisodeId episodeId;

	@Column(name = ContainsDatabase.COLUMN_EPISODE_EPISODE, nullable = false, length = 10, insertable = false, updatable = false)
	private int episode;

	@Column(name = ContainsDatabase.COLUMN_EPISODE_LINK, nullable = false, columnDefinition = "TEXT")
	private String link;

	@Column(name = ContainsDatabase.COLUMN_EPISODE_FK_ID_MOVIE, length = 10, nullable = false, insertable = false, updatable = false)
	private String fkIdMovie;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = ContainsDatabase.COLUMN_EPISODE_FK_ID_MOVIE, referencedColumnName = ContainsDatabase.COLUMN_MOVIE_PK_ID_MOVIE, foreignKey = @ForeignKey(name = ContainsDatabase.FOREIGN_EPISODE_FK_ID_MOVIE), insertable = false, updatable = false)
	private Movie movie;

	@Data
	@Embeddable
	public static class EpisodeId implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = -2130560778130045243L;

		@Column(name = ContainsDatabase.COLUMN_EPISODE_FK_ID_MOVIE, length = 10, nullable = false)
		private Integer fkIdMovie;

		@Column(name = ContainsDatabase.COLUMN_EPISODE_EPISODE, length = 10, nullable = false)
		private Integer episode;
	}
}
