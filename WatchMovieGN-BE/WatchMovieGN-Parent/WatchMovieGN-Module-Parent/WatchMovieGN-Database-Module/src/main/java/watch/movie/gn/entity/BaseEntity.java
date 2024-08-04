package watch.movie.gn.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import watch.movie.gn.util.ConstantDatabase;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = ConstantDatabase.BASE_ENTITY_COLUMN_DATE_CREATE, nullable = false, updatable = false)
	@CreationTimestamp
	private Date dateCreate;

	@Column(name = ConstantDatabase.BASE_ENTITY_COLUMN_DATE_UPDATE, nullable = false)
	@UpdateTimestamp
	private Date dateUpdate;
}
