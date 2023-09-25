package ua.nure.freedel.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.nure.freedel.courier.Courier;
import ua.nure.freedel.order.orderItem.OrderItem;
import ua.nure.freedel.user.User;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByUserEmail(String email);
    
    List <Order> findByCourierId(Long id);

    @Modifying
    @Query("UPDATE Order o SET o.address = :address, o.total = :total," +
            " o.creationDate = :creationDate, o.user = :user, " +
            "o.items = :items, o.courier = :courier," +
            " o.status = :status WHERE o.id = :orderId")
    void update(@Param("orderId") Long orderId,
                @Param("address") String address,
                @Param("total") double total,
                @Param("creationDate") Date creationDate,
                @Param("user") User user,
                @Param("items") List<OrderItem> items,
                @Param("courier") Courier courier,
                @Param("status") OrderStatus status);


    List<Order> findByStatus(OrderStatus status);
}
