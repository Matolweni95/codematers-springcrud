package codemasters.codematersspringcrud.controllers;

import codemasters.codematersspringcrud.jwt.auth.AuthenticationRequest;
import codemasters.codematersspringcrud.jwt.auth.AuthenticationResponse;
import codemasters.codematersspringcrud.service.AuthenticationService;
import codemasters.codematersspringcrud.jwt.auth.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private  final AuthenticationService service;
    @PostMapping(path = "/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }
}
