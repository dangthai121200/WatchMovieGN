package watch.movie.gn.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import watch.movie.gn.entity.BaseEntity;

@Getter
@Setter
@Table(name = "ConfigurationType")
@Entity(name = "ConfigurationType")
public class ConfigurationType extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1096581227902745994L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_ID_CONFIGURATION_TYP", length = 10)
	private int pkIdConfigurationTyp;

	@Column(name = "NAME")
	private String name;

	@Column(name = "DESCRIPTIONS")
	private String descr;

}
