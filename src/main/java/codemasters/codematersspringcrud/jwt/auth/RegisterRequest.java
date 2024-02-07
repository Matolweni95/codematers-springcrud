package codemasters.codematersspringcrud.jwt.auth;

import codemasters.codematersspringcrud.role.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class RegisterRequest {
    private String firstname;
    private String lastname;
//    private String imageURL;
    private String email;
    private  String password;
    private Role role;

}
