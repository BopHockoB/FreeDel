package ua.nure.freedel.registration.token;

import ua.nure.freedel.user.User;

import java.util.Optional;



public interface IVerificationTokenService {
    String validateToken(String token);
    void saveVerificationTokenForUser(User user, String token);
    Optional<VerificationToken> findByToken(String token);


    void deleteUserToken(Long id);
}
