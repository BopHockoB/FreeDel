package ua.nure.freedel.restaurant;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.nure.freedel.user.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RestaurantService implements IRestaurantService {
    private final RestaurantRepository restaurantRepository;

    public Restaurant getById(Long id) {
        return restaurantRepository.findById(id).get();
    }

    @Transactional
    public void update(Restaurant restaurant) {
        restaurantRepository.update(
                restaurant.getId(),
                restaurant.getName(),
                restaurant.getAveragePrepTime(),
                restaurant.getDeliveryCommission(),
                restaurant.getRate(),
                restaurant.getAddress(),
                restaurant.getIsWorking(),
                restaurant.getRestaurantCategory().getId()
        );
    }
    @Transactional
    public void deleteRestaurant(Long id) {
        restaurantRepository.deleteById(id);
    }

    public Restaurant createRestaurant(Restaurant restaurant) {
        Restaurant createdRestaurant = restaurantRepository.save(restaurant);
        return createdRestaurant;
    }
    public List<Restaurant> getAllRestaurants() {
        List<Object[]> results = restaurantRepository.findAllRestaurants();
        List<Restaurant> restaurants = new ArrayList<>();

        for (Object[] result : results) {

            Restaurant restaurant = Restaurant.builder()
                    .id((Long) result[0])
                    .name((String) result[1])
                    .averagePrepTime((Date) result[2])
                    .deliveryCommission((Double) result[3])
                    .rate((Double) result[4])
                    .address((String) result[5])
                    .isWorking((Boolean) result[6])
                    .restaurantCategory(RestaurantCategory.builder()
                            .id((Long) result[7])
                            .name((String) result[8])
                            .build())
                    .build();

            restaurants.add(restaurant);
        }

        return restaurants;
    }
}
