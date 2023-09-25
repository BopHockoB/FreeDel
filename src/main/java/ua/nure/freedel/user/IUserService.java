package ua.nure.freedel.user;

import ua.nure.freedel.order.Order;
import ua.nure.freedel.registration.RegistrationRequest;

import java.util.List;
import java.util.Optional;



public interface IUserService {
    List<User> getAllUsers();
    User registerUser(RegistrationRequest registrationRequest);
   Optional<User> findByEmail(String email);

    Optional<User> findById(Long id);

    void updateUser(Long id, String firstName, String lastName, String email);

    void deleteUser(Long id);


    User getCurrentUser();

}
