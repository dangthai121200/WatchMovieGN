package watch.movie.gn.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "ConfigurationType")
@Entity(name = "ConfigurationType")
@Data
public class ConfigurationType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_ID_CONFIGURATION_TYP", length = 10)
	private int pkIdConfigurationTyp;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "DESCRIPTIONS")
	private String descr;
	
}
