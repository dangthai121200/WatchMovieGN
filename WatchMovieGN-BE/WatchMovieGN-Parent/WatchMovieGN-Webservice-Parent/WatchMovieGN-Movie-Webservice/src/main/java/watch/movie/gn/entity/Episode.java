package watch.movie.gn.entity;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import watch.movie.gn.util.ConstantDatabase;

@Getter
@Setter
@Table(name = ConstantDatabase.TABLE_EPISODE)
@Entity(name = ConstantDatabase.TABLE_EPISODE)
public class Episode extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3256886363771706573L;

	@EmbeddedId
	private EpisodeId episodeId;

	@Column(name = ConstantDatabase.COLUMN_EPISODE_EPISODE, nullable = false, length = 10, insertable = false, updatable = false)
	private int episode;

	@Column(name = ConstantDatabase.COLUMN_EPISODE_LINK, nullable = false, columnDefinition = "TEXT")
	private String link;

	@Column(name = ConstantDatabase.COLUMN_EPISODE_FK_ID_MOVIE, length = 10, nullable = false, insertable = false, updatable = false)
	private String fkIdMovie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = ConstantDatabase.COLUMN_EPISODE_FK_ID_MOVIE, referencedColumnName = ConstantDatabase.COLUMN_MOVIE_PK_ID_MOVIE, foreignKey = @ForeignKey(name = ConstantDatabase.FOREIGN_EPISODE_FK_ID_MOVIE), insertable = false, updatable = false)
	private Movie movie;

	@Data
	@Embeddable
	public static class EpisodeId implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = -2130560778130045243L;

		@Column(name = ConstantDatabase.COLUMN_EPISODE_FK_ID_MOVIE, length = 10, nullable = false)
		private Integer fkIdMovie;

		@Column(name = ConstantDatabase.COLUMN_EPISODE_EPISODE, length = 10, nullable = false)
		private Integer episode;
	}
}
