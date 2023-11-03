package watch.movie.gn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import watch.movie.gn.domain.movie.GetAllMovieRequest;
import watch.movie.gn.service.MovieDocumentService;
import watch.movie.gn.util.UrlUtil;

@RestController
@RequestMapping(UrlUtil.MOVIE_CONTROLLER_V1)
public class MovieDocumentController {
	
	@Autowired
	private MovieDocumentService movieDocumentService;

	@PostMapping(UrlUtil.MOVIE_CONTROLLER_V1_GET_ALL_MOVIE)
	public ResponseEntity<?> getAllMovie(@RequestBody GetAllMovieRequest getAllMovieRequest) {
		return ResponseEntity.ok(movieDocumentService.getAllMovie(getAllMovieRequest));
	}
}
