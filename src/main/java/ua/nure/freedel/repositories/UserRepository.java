package ua.nure.freedel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.nure.freedel.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);
    Optional<User> findById(Integer id);
}
