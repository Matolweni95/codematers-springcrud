package codemasters.codematersspringcrud.controllers;

import codemasters.codematersspringcrud.service.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
public class EmailController {

    @Autowired
    private EmailService service;

    @PostMapping("/send-login-details")
    public ResponseEntity<String> sendLoginDetails(@RequestBody Map<String, String> userDetails) {
        String email = userDetails.get("email");
        String password = userDetails.get("password");
        service.sendEmail(email, "Login Details", "Your email: " + email + "\nYour password: " + password);
        return ResponseEntity.ok("Login details sent successfully");
    }
}
