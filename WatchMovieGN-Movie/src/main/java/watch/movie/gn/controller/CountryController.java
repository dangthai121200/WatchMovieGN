package watch.movie.gn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import watch.movie.gn.domain.CreateCountryRequest;
import watch.movie.gn.domain.CreateMovieRequest;
import watch.movie.gn.service.CountryService;

@RestController
@RequestMapping("/v1/country")
public class CountryController {

	@Autowired
	public CountryService countryService;

	@GetMapping
	public ResponseEntity<?> getAllCountry() {
		return ResponseEntity.ok(countryService.getAllCountry());
	}
	
	@PostMapping
	public ResponseEntity<?> createCountry(@RequestBody CreateCountryRequest createCountryRequest) {
		countryService.createCountry(createCountryRequest);
		return ResponseEntity.ok().build();
	}
}
