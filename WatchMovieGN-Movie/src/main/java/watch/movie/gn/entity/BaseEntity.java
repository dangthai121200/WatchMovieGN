package watch.movie.gn.entity;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import watch.movie.gn.util.ContainsDatabase;

@Data
@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = ContainsDatabase.BASE_ENTITY_COLUMN_DATE_CREATE, nullable = false, updatable = false)
	@CreationTimestamp
	private Date dateCreate;

	@Column(name = ContainsDatabase.BASE_ENTITY_COLUMN_DATE_UPDATE, nullable = false)
	@UpdateTimestamp
	private Date dateUpdate;
}
