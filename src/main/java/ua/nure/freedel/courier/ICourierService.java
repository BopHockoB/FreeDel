package ua.nure.freedel.courier;

import ua.nure.freedel.order.Order;

import java.util.List;
import java.util.Optional;

public interface ICourierService{
    List<Courier> getAllCouriers();

    Courier findById(Long id);

    void update(Courier courier);

    void deleteCourier(Long id);

    void linkCourierAndOrder(Long id, Long orderId);

    List<Order> getOrders(Long id);
}