package ua.nure.freedel.cart;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;


@Service
public class CartManager {

    private static final String SHOPPING_CART_KEY = "shoppingCart";

    public Cart getCart(HttpSession session){
        Cart cart = (Cart) session.getAttribute(SHOPPING_CART_KEY);
        if(cart == null){
            cart = new Cart();
            setCart(session, cart);
        }
        return cart;
    }

    public void setCart(HttpSession session, Cart cart){
        session.setAttribute(SHOPPING_CART_KEY, cart);
    }

    public void removeCart(HttpSession session){
        session.removeAttribute(SHOPPING_CART_KEY);
    }
}