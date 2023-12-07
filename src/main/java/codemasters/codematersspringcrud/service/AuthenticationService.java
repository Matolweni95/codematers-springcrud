package codemasters.codematersspringcrud.service;

import codemasters.codematersspringcrud.token.UserDetailsDTO;
import codemasters.codematersspringcrud.jwt.auth.AuthenticationRequest;
import codemasters.codematersspringcrud.jwt.auth.AuthenticationResponse;
import codemasters.codematersspringcrud.jwt.auth.RegisterRequest;
import codemasters.codematersspringcrud.jwt.config.JwtService;
import codemasters.codematersspringcrud.entity.User;
import codemasters.codematersspringcrud.repository.UserRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request, HttpServletResponse response) {

        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();
        repository.save(user);
        var userDetailsDTO = convertUserToUserDetailsDTO(user);
        var jwtToken = jwtService.generateToken(userDetailsDTO);

        Cookie tokenCookie = new Cookie("accessToken", jwtToken);
        tokenCookie.setHttpOnly(true);
        response.addCookie(tokenCookie);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request, HttpServletResponse response) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                     request.getEmail(),
                     request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail()).orElseThrow();
        var userDetailsDTO = convertUserToUserDetailsDTO(user);
        var jwtToken = jwtService.generateToken(userDetailsDTO);

        Cookie tokenCookie = new Cookie("accessToken", jwtToken);
        tokenCookie.setHttpOnly(true);
        response.addCookie(tokenCookie);

        return AuthenticationResponse.builder()
                .token(jwtToken).
                build();
    }

    private UserDetailsDTO convertUserToUserDetailsDTO(User user) {
        UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
        userDetailsDTO.setId(user.getId());
        userDetailsDTO.setFirstname(user.getFirstname());
        userDetailsDTO.setRole(user.getRole());
        userDetailsDTO.setLastname(user.getLastname());
        return userDetailsDTO;
    }
}
