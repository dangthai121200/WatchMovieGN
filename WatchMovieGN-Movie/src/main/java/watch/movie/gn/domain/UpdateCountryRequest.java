package watch.movie.gn.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class UpdateCountryRequest {
	List<CountryDomain> countries = new ArrayList<>();
}
