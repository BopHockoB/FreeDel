package ua.nure.freedel.home;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.nure.freedel.order.IOrderService;
import ua.nure.freedel.order.Order;
import ua.nure.freedel.product.ProductCategoryRepository;
import ua.nure.freedel.user.IUserService;
import ua.nure.freedel.user.User;

import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class HomeController {
    private final ProductCategoryRepository productCategoryRepository;
    private final IUserService userService;
    private final IOrderService orderService;


    @GetMapping
    public String homePage(){
        if (userService.getCurrentUser() == null)
        return "home";

        return "redirect:/profile";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/error")
    public String error(){
        return "error";
    }

    @GetMapping("/main")
    public String mainMenu(Model model){
    model.addAttribute("categories", productCategoryRepository.findAll());
        return "main";
    }

    @GetMapping("/profile")
    @Secured("ROLE_USER")
    public String profile(Model model){
        if (userService.getCurrentUser() == null)
            return "redirect:/";

        User currentUser = userService.getCurrentUser();
        model.addAttribute("user", currentUser);

        List<Order> orders = orderService.getUserOrdersByUsername(currentUser.getEmail());
        model.addAttribute("orders", orders.stream()
                .sorted(( a, b ) -> {
                    return b.getId().compareTo(a.getId());
                })
                .toList());

        return "profile";
    }

}
