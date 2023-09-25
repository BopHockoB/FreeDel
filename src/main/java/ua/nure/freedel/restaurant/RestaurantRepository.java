package ua.nure.freedel.restaurant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    @Query(value = "SELECT r.id, r.name, r.average_prep_time, r.delivery_commission, r.rate, r.address, r.is_working, " +
            "rc.id AS restaurant_category_id, rc.name AS restaurant_category_name " +
            "FROM restaurant r " +
            "JOIN restaurant_category rc ON r.restaurant_category_id = rc.id",
            nativeQuery = true)
    List<Object[]> findAllRestaurants();

    @Modifying
    @Query(value = "UPDATE restaurant SET name = :name, average_prep_time = :averagePrepTime, " +
            "delivery_commission = :deliveryCommission, rate = :rate, address = :address, " +
            "is_working = :isWorking, restaurant_category_id = :restaurantCategoryId WHERE id = :id", nativeQuery = true)
    void update(@Param("id") Long id, @Param("name") String name,
                          @Param("averagePrepTime") Date averagePrepTime, @Param("deliveryCommission") Double deliveryCommission,
                          @Param("rate") Double rate, @Param("address") String address, @Param("isWorking") Boolean isWorking,
                          @Param("restaurantCategoryId") Long restaurantCategoryId);

    Optional<Restaurant> findByName(String name);
}
