package watch.movie.gn.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import watch.movie.gn.security.domain.GenerateTokenReponse;
import watch.movie.gn.security.domain.GenerateTokenRequest;
import watch.movie.gn.security.service.AuthenticationService;


@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/generatetoken")
    public ResponseEntity<?> generateToken(GenerateTokenRequest generateTokenRequest) {
        return ResponseEntity.ok(authenticationService.generateToken(generateTokenRequest));
    }
}
