package ua.nure.freedel.order.orderItem;


import jakarta.persistence.*;
import lombok.*;
import ua.nure.freedel.cart.CartItem;
import ua.nure.freedel.order.Order;
import ua.nure.freedel.product.Product;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private double subTotal;
    private int quantity;

    public OrderItem(CartItem cartItem){
        this.product = cartItem.getProduct();
        this.quantity = cartItem.getQuantity();
        this.subTotal = cartItem.getSubTotal();
    }
}