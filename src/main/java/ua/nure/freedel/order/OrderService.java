package ua.nure.freedel.order;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService implements IOrderService{

    private final OrderRepository orderRepository;
    @Override
    public List<Order> getUserOrdersByUsername(String username) {
        List<Order> list = orderRepository.findAllByUserEmail(username);
        list.sort(Comparator.comparing(Order::getCreationDate));

        return list;
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> findOrdersByStatus(OrderStatus status) {
        return orderRepository.findByStatus(status);
    }

    @Override
    public Order getById(Long id) {
        return orderRepository.findById(id).get();
    }

    @Override
    @Transactional
    public void update(Order order) {
//        orderRepository.update(order.getId(),order.getAddress(),
//                order.getTotal(), order.getCreationDate(),
//                order.getUser(), order.getItems(),
//                order.getCourier(), order.getStatus());
        orderRepository.save(order);
    }


}
