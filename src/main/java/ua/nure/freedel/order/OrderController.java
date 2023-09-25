package ua.nure.freedel.order;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.nure.freedel.cart.CartManager;
import ua.nure.freedel.cart.Cart;
import ua.nure.freedel.restaurant.Restaurant;
import ua.nure.freedel.user.IUserService;
import ua.nure.freedel.utility.DistanceCalculatorService;

import java.util.Date;

@Controller
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final CartManager cartManager;
    private final DistanceCalculatorService distanceCalculator;
    private final IUserService userService;
    private final IOrderService orderService;

    @PostMapping("/save")
    public String saveOrder(HttpSession session, @RequestParam("address") String address){
        Cart cart = cartManager.getCart(session);

        if (cart.getItems().isEmpty())
            return "redirect:/cart?empty";

//        for (Restaurant r:
//                cart.getAllRestaurants()) {
//                    double distance = distanceCalculator.calculateDistance(address, r.getAddress());
//                    if (distance < 0)
//                        throw new IllegalArgumentException("Distance less than 0");
//                    if (distance > 10)
//                        return "redirect:/cart?distance=" + distance;
//        }

        Order order = new Order();
        order.setItems(cart.toOrderItemList(order));
        order.setUser(userService.getCurrentUser());
        order.setAddress(address);
        order.setTotal(cart.getTotal());
        order.setCreationDate(new Date(System.currentTimeMillis()));

        orderService.save(order);

        cartManager.removeCart(session);
        return "redirect:/profile";
    }
}
