package codemasters.codematersspringcrud.service;

import codemasters.codematersspringcrud.entity.User;
import codemasters.codematersspringcrud.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public void deleteUserById(Integer id) {
        repository.deleteById(id);
    }

    public User getUserById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public User updateUser(Integer id, User updatedUser) {
        User existingUser = repository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setFirstname(updatedUser.getFirstname());
            existingUser.setLastname(updatedUser.getLastname());
            existingUser.setEmail(updatedUser.getEmail());
            return repository.save(existingUser);
        }

        return null;
    }

    public User updatePassword(Integer id, String oldPassword, String newPassword) {
        User existingUser = repository.findById(id).orElse(null);
        if (existingUser != null && passwordEncoder.matches(oldPassword, existingUser.getPassword())) {
            existingUser.setPassword(passwordEncoder.encode(newPassword));
            return repository.save(existingUser);
        }
        return null;
    }

}
