package ua.nure.freedel.courier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.nure.freedel.order.Order;
import ua.nure.freedel.user.role.Role;

import java.util.Collection;
import java.util.List;

public interface CourierRepository extends JpaRepository<Courier, Long> {
    @Modifying
    @Query("UPDATE Courier c SET c.firstName = :firstName, c.lastName = :lastName, c.email = :email, " +
            "c.roles = :roles, c.phoneNumber = :phoneNumber, c.transportType = :transportType, " +
            "c.orders = :orders, c.isBusy = :isBusy WHERE c.id = :id")
    void update(
            @Param("id") Long id,
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("email") String email,
            @Param("roles") Collection<Role> roles,
            @Param("phoneNumber") String phoneNumber,
            @Param("transportType") TransportType transportType,
            @Param("orders") List<Order> orders,
            @Param("isBusy") boolean isBusy
    );
}
