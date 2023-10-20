package watch.com.gn.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import watch.movie.gn.entity.BaseEntity;
import watch.movie.gn.util.ContainsDatabase;

@Getter
@Setter
@Table(name = ContainsDatabase.TABLE_ROLE)
@Entity(name = "Role")
public class Role extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1414131923069552475L;

	@Id
	@Column(name = ContainsDatabase.COLUMN_ROLE_PK_ID_ROLE, length = 10)
	private int pkIdRole;

	@Column(name = ContainsDatabase.COLUMN_ROLE_NAME, nullable = false, unique = true, length = 20)
	private String name;

}
