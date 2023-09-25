package ua.nure.freedel.cart;

import lombok.Data;
import ua.nure.freedel.product.Product;


@Data
public class CartItem {
    private final Product product;
    private int quantity;
    private double subTotal;

    public CartItem(Product product) {
        this.product = product;
        this.quantity = 1;
        this.subTotal = product.getPrice().doubleValue();
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
        this.subTotal = quantity * product.getPrice();
    }

}