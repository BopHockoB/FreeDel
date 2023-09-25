package ua.nure.freedel.product;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.nure.freedel.restaurant.Restaurant;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int amount;
    private String description;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
    private boolean available;
    @ManyToOne
    @JoinColumn(name = "product_category_id")
    private ProductCategory productCategory;

    public Product(Long id, String name, int amount,
                   String description, Double price,
                   Restaurant restaurant, boolean available,
                   ProductCategory productCategory) {

        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setAmount(amount);
        product.setDescription(description);
        product.setPrice(price);
        product.setRestaurant(restaurant);
        product.setAvailable(available);
        product.setProductCategory(productCategory);
    }
}
