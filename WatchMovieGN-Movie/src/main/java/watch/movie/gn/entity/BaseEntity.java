package watch.movie.gn.entity;

import java.util.Date;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import watch.movie.gn.util.ContainsDatabase;

@Data
@MappedSuperclass
public abstract class BaseEntity {

	@Column(name = ContainsDatabase.BASE_ENTITY_COLUMN_DATE_CREATE)
	@CreatedDate
	private Date dateCreate;

	@Column(name = ContainsDatabase.BASE_ENTITY_COLUMN_DATE_UPDATE)
	@UpdateTimestamp
	private Date dateUpdate;
}
