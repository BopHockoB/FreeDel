package ua.nure.freedel.cart;

import lombok.Getter;
import lombok.Setter;
import ua.nure.freedel.order.Order;
import ua.nure.freedel.order.orderItem.OrderItem;
import ua.nure.freedel.product.Product;
import ua.nure.freedel.restaurant.Restaurant;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class Cart {
    // private final User user;
    private final List<CartItem> items;
    private double total;

    public Cart() {
        items = new ArrayList<>();
        total = 0;
    }

    public CartItem getItem(Product product){
        for (CartItem item : items){
            if(item.getProduct().getId().equals(product.getId())){
                return item;
            }
        }
        return null;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void addItem(CartItem item){
        addItem(item.getProduct(), item.getQuantity());
    }

    public void addItem(Product product, int quantity){
        CartItem item = getItem(product);

        if (item != null){
            item.setQuantity(item.getQuantity() + quantity);
        } else {
            item = new CartItem(product);
            item.setQuantity(quantity);
            items.add(item);
        }
    }

    public void updateItem(Product product, int quantity){ // throws ProductNotFoundException
        CartItem item = getItem(product);

        if (item != null){
            item.setQuantity(quantity);
        } else {
            // throw new ProductNotFoundException();
        }
    }

    public void removeItem(Product product){ // throws ProductNotFoundException
        CartItem item = getItem(product);

        if (item != null){
            items.remove(item);
        } else {
            // throw new ProductNotFoundException();
        }
    }

    public List<OrderItem> toOrderItemList(Order order){
        if (items.isEmpty())
            return new ArrayList<>();
        List<OrderItem> orderItems = new ArrayList<>();
        for (CartItem item:
             items) {
            OrderItem orderItem = new OrderItem(item);
            orderItem.setOrder(order);
             orderItems.add(orderItem);
        }
       return orderItems;
    }



    public void clear(){
        items.clear();
        total = 0;
    }

    public double getTotal(){
        total = 0;
        for (CartItem item : items) {
            total += item.getSubTotal();
        }
        return total;
    }

    public Set<Restaurant> getAllRestaurants(){
        Set<Restaurant> restaurants = new HashSet<>();

        for (CartItem i:
                items) {
            restaurants.add(i.getProduct().getRestaurant());
        }

        return restaurants;
    }
}