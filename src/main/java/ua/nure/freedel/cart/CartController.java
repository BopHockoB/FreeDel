package ua.nure.freedel.cart;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.nure.freedel.product.IProductService;
import ua.nure.freedel.product.Product;
import ua.nure.freedel.product.ProductService;
import ua.nure.freedel.user.IUserService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {

    private final CartManager cartManager;
    private final IProductService productService;


    @GetMapping
    public String getCart(Model model, HttpSession session) {
        model.addAttribute("cart", cartManager.getCart(session));
        return "cart";
    }

    @PostMapping("/add")
    public String add(HttpSession session, @RequestParam("id") Product product,
                      @RequestParam(value = "qty", required = false, defaultValue = "1") int qty) {
        Cart cart = cartManager.getCart(session);
        cart.addItem(product, qty);
        return "redirect:/main";
    }

    @PostMapping("/remove")
    public String remove(HttpSession session, @RequestParam("id") Long id) {
        Product product = productService.getById(id);
        Cart cart = cartManager.getCart(session);
        cart.removeItem(product);
        return "redirect:/cart";
    }

    @PostMapping("/update")
    public String update(HttpSession session, @RequestParam("id") Long id, @RequestParam("qty") int qty) {
        Product product = productService.getById(id);
        Cart cart = cartManager.getCart(session);
        cart.updateItem(product, qty);
        return "redirect:/cart";
    }

}