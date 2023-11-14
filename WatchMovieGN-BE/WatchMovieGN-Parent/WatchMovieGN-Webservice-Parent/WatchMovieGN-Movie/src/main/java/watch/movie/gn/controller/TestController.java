package watch.movie.gn.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

import watch.movie.gn.service.TestService;
import watch.movie.gn.util.ProfileActive;

@Profile(ProfileActive.PROFILE_DEV)
@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	private TestService testService;

	@GetMapping("/fakeDataMovie")
	public ResponseEntity<?> fakeDataMovie() throws StreamReadException, DatabindException, IOException {

		return ResponseEntity.ok().body(testService.fakeDataMovie());
	}
}
