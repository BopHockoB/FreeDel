package ua.nure.freedel.courier;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransportTypeRepository extends JpaRepository<TransportType, Long> {
    Optional<TransportType> findById(Long id);
}