package watch.movie.gn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import watch.movie.gn.domain.CreateCountryRequest;
import watch.movie.gn.domain.DeleteCountryRequest;
import watch.movie.gn.domain.UpdateCountryRequest;
import watch.movie.gn.exception.WatchMovieException;
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
	
	@PutMapping
	public ResponseEntity<?> updateCountry(@RequestBody UpdateCountryRequest updateCountryRequest)
			throws WatchMovieException {
		countryService.updateCountry(updateCountryRequest);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping
	public ResponseEntity<?> deleteCountry(@RequestBody DeleteCountryRequest deleteCountryRequest)
			throws WatchMovieException {
		countryService.deleteCountry(deleteCountryRequest);
		return ResponseEntity.ok().build();
	}
}
