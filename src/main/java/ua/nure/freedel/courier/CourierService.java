package ua.nure.freedel.courier;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.nure.freedel.order.IOrderService;
import ua.nure.freedel.order.Order;
import ua.nure.freedel.order.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourierService implements ICourierService{
    private final CourierRepository courierRepository;
    private final IOrderService orderService;
    private final OrderRepository orderRepository;

    @Override
    public List<Courier> getAllCouriers() {
       return courierRepository.findAll();
    }

    @Override
    public Courier findById(Long id) {
        return courierRepository.findById(id).get();
    }

    @Override
    @Transactional
    public void update(Courier courier) {
//        courierRepository.update(courier.getId(),
//                courier.getFirstName(),
//                courier.getLastName(),
//                courier.getEmail(),
//                courier.getRoles(),
//                courier.getPhoneNumber(),
//                courier.getTransportType(),
//                courier.getOrders(),
//                courier.isBusy());
        courierRepository.save(courier);

    }


    @Override
    public void deleteCourier(Long id) {

    }

    @Override
    public void linkCourierAndOrder(Long id, Long orderId) {
        Courier courier = findById(id);
        courier.getOrders().add(orderService.getById(orderId));
        update(courier);
    }

    @Override
    public List<Order> getOrders(Long id) {
        return orderRepository.findByCourierId(id);
    }


}
