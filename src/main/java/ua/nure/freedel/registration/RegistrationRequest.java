package ua.nure.freedel.registration;

//import ua.nure.freedel.user.role.Role;
import lombok.Data;

import java.util.List;
@Data
public class RegistrationRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
//    private List<Role> roles;
}
