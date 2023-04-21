package watch.movie.gn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import watch.movie.gn.domain.CreateMovieRequest;
import watch.movie.gn.domain.GetAllMovieRequest;
import watch.movie.gn.domain.UpdateMovieRequest;
import watch.movie.gn.service.MovieService;

@RestController
@RequestMapping("/v1/movie")
public class MovieController {

	@Autowired
	public MovieService movieService;

	@PostMapping("/getAll")
	public ResponseEntity<?> getAllMovie(@RequestBody GetAllMovieRequest getAllMovieRequest) {
		return ResponseEntity.ok(movieService.getAllMovie(getAllMovieRequest));
	}

	@PostMapping
	public ResponseEntity<?> createMovie(@RequestBody CreateMovieRequest createMovieRequest) {
		movieService.createMovie(createMovieRequest);
		return ResponseEntity.ok().build();
	}

	@PutMapping
	public ResponseEntity<?> updateMovie(@RequestBody UpdateMovieRequest updateMovieRequest) {
		movieService.updateMovie(updateMovieRequest);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/pullMovie")
	public ResponseEntity<?> pullMovie() {
		movieService.pullMovie();
		return ResponseEntity.ok().build();
	}
}
