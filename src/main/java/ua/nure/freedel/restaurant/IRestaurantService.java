package ua.nure.freedel.restaurant;

import java.util.List;

public interface IRestaurantService {
    List<Restaurant> getAllRestaurants();
    Restaurant getById(Long id);
    void update(Restaurant restaurant);
    void deleteRestaurant(Long id);
    Restaurant createRestaurant(Restaurant restaurant);

}
