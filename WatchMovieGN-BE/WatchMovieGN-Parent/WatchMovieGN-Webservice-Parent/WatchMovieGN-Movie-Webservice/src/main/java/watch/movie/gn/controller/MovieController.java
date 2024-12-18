package watch.movie.gn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import watch.movie.gn.domain.movie.CreateMovieRequest;
import watch.movie.gn.domain.movie.UpdateMovieRequest;
import watch.movie.gn.exception.WatchMovieException;
import watch.movie.gn.foreignkey.MovieForeign;
import watch.movie.gn.service.MovieService;
import watch.movie.gn.util.UrlConstant;

@RestController
@RequestMapping(UrlConstant.MOVIE_CONTROLLER_V1)
public class MovieController {

	@Autowired
	public MovieService movieService;

	@Autowired
	public MovieForeign movieForeign;

	@PostMapping
	public ResponseEntity<?> createMovie(@RequestBody CreateMovieRequest createMovieRequest) {
		movieService.createMovie(createMovieRequest);
		return ResponseEntity.ok().build();
	}

	@PutMapping
	public ResponseEntity<?> updateMovie(@RequestBody UpdateMovieRequest updateMovieRequest)
			throws WatchMovieException {
		movieService.updateMovie(updateMovieRequest);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/pullMovie")
	public ResponseEntity<?> pullMovie() {
		movieService.pullMovie();
		return ResponseEntity.ok().build();
	}

//	@GetMapping("/fk")
//	public ResponseEntity<?> fk() {
//		movieForeign.updateFkOptinonDeleteToSetNull();
//		return ResponseEntity.ok().build();
//	}
}
