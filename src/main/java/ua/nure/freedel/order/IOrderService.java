package ua.nure.freedel.order;

import java.util.List;

public interface IOrderService {
    List<Order> getUserOrdersByUsername(String username);

    Order save(Order order);


    List<Order> findOrdersByStatus(OrderStatus status);

    Order getById(Long orderId);

    void update(Order order);
}
