package watch.movie.gn.domain.country;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class GetAllCountryResponse {
	private List<CountryDomain> countries = new ArrayList<>();
}
