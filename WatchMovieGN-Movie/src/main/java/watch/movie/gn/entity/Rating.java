//package watch.movie.gn.entity;
//
//import java.io.Serializable;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Embeddable;
//import jakarta.persistence.EmbeddedId;
//import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.ForeignKey;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.OneToOne;
//import jakarta.persistence.Table;
//import lombok.Data;
//import lombok.Getter;
//import lombok.Setter;
//import watch.movie.gn.util.ContainsDatabase;
//
//@Getter
//@Setter
//@Entity(name = ContainsDatabase.TABLE_RATING)
//@Table(name = ContainsDatabase.TABLE_RATING)
//public class Rating extends BaseEntity {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = -1166570680283548728L;
//
//	@EmbeddedId
//	private RatingId ratingId;
//
//	@Column(name = ContainsDatabase.COLUMN_RATING_RATING, length = 10)
//	private Float rating;
//
//	@Column(name = ContainsDatabase.COLUMN_RATING_COMMENT, length = 10, columnDefinition = "TEXT")
//	private String comment;
//
//	@Column(name = ContainsDatabase.COLUMN_RATING_FK_ID_MOVIE, length = 10, insertable = false, updatable = false)
//	private Integer fkIdMovie;
//
//	@OneToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = ContainsDatabase.COLUMN_RATING_FK_ID_MOVIE, referencedColumnName = ContainsDatabase.COLUMN_MOVIE_PK_ID_MOVIE, foreignKey = @ForeignKey(name = ContainsDatabase.FOREIGN_RATING_FK_ID_MOVIE), insertable = false, updatable = false)
//	private Movie movie;
//
//	@Data
//	@Embeddable
//	public static class RatingId implements Serializable {
//		/**
//		 * 
//		 */
//		private static final long serialVersionUID = -2029929882279772926L;
//
//		@Column(name = ContainsDatabase.COLUMN_RATING_FK_ID_MOVIE, length = 10)
//		private Integer fkIdMovie;
//
//		// private Integer fkIdUser;
//	}
//}
