package ua.nure.freedel.restaurant;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date averagePrepTime;
    private Double deliveryCommission;
    private Double rate;
    private String address;
    private Boolean isWorking;
    @ManyToOne
    @JoinColumn(name = "restaurant_category_id")
    private RestaurantCategory restaurantCategory;
    public Restaurant(Long id, String name){
        Restaurant restaurant = new Restaurant();
        restaurant.setId(id);
        restaurant.setName(name);
    }
}
