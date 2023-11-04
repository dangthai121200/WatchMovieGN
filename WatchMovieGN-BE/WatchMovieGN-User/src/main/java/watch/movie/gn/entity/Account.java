package watch.movie.gn.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import watch.movie.gn.util.ConstantDatabase;

@Getter
@Setter
@Entity(name = ConstantDatabase.TABLE_ACCOUNT)
@Table(name = ConstantDatabase.TABLE_ACCOUNT)
public class Account extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1576969169493927022L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = ConstantDatabase.COLUMN_ACCOUNT_PK_ID_ACCOUNT, length = 10)
	private int pkIdAccount;
	@Column(name = ConstantDatabase.COLUMN_ACCOUNT_USERNAME, length = 255, unique = true, nullable = false)
	private String username;
	@Column(name = ConstantDatabase.COLUMN_ACCOUNT_PASSWORD, length = 255, nullable = false)
	private String password;
}
