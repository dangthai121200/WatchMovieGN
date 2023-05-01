package watch.movie.gn.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "ConfigurationType")
@Entity(name = "ConfigurationType")
public class ConfigurationType extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_ID_CONFIGURATION_TYP", length = 10)
	private int pkIdConfigurationTyp;

	@Column(name = "NAME")
	private String name;

	@Column(name = "DESCRIPTIONS")
	private String descr;

}
