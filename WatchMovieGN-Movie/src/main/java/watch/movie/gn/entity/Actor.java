//package watch.movie.gn.entity;
//
//import java.util.Date;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//import lombok.Getter;
//import lombok.Setter;
//import watch.movie.gn.util.ContainsDatabase;
//
//@Getter
//@Setter
//@Entity(name = ContainsDatabase.TABLE_ACTOR)
//@Table(name = ContainsDatabase.TABLE_ACTOR)
//public class Actor extends BaseEntity {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = ContainsDatabase.COLUMN_ACTOR_PK_ID_ACTOR, length = 10)
//	private int pkIdActor;
//
//	@Column(name = ContainsDatabase.COLUMN_ACTOR_LAST_NAME, length = 255, unique = false, nullable = false)
//	private String lastName;
//
//	@Column(name = ContainsDatabase.COLUMN_ACTOR_FIRST_NAME, length = 255, unique = false, nullable = false)
//	private String firstName;
//
//	@Column(name = ContainsDatabase.COLUMN_ACTOR_BIRTHDAY, nullable = true)
//	private Date birthday;
//
//	@Column(name = ContainsDatabase.COLUMN_ACTOR_GENDER, length = 255, nullable = true)
//	private String gender;
//
//	@Column(name = ContainsDatabase.COLUMN_ACTOR_RANK, length = 255, nullable = true)
//	private String rank;
//}
