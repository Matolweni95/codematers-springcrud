package codemasters.codematersspringcrud.controllers;

import codemasters.codematersspringcrud.jwt.auth.AuthenticationRequest;
import codemasters.codematersspringcrud.jwt.auth.AuthenticationResponse;
import codemasters.codematersspringcrud.service.AuthenticationService;
import codemasters.codematersspringcrud.jwt.auth.RegisterRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private  final AuthenticationService service;
    @PostMapping(path = "/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request, HttpServletResponse response
    ) {
        AuthenticationResponse registerResponse = service.register(request, response);
        return ResponseEntity.ok(registerResponse);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request, HttpServletResponse response
    ) {
        AuthenticationResponse authenticationResponse = service.authenticate(request, response);
        return ResponseEntity.ok(authenticationResponse);
    }
}
