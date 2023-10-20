package watch.com.gn.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import watch.movie.gn.entity.BaseEntity;
import watch.movie.gn.util.ContainsDatabase;

@Getter
@Setter
@Entity(name = ContainsDatabase.TABLE_ACCOUNT)
@Table(name = ContainsDatabase.TABLE_ACCOUNT)
public class Account extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1576969169493927022L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = ContainsDatabase.COLUMN_ACCOUNT_PK_ID_ACCOUNT, length = 10)
	private int pkIdAccount;
	@Column(name = ContainsDatabase.COLUMN_ACCOUNT_USERNAME, length = 255, unique = true, nullable = false)
	private String username;
	@Column(name = ContainsDatabase.COLUMN_ACCOUNT_PASSWORD, length = 255, nullable = false)
	private String password;
}
