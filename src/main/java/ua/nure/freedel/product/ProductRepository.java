package ua.nure.freedel.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT p.id, p.name, p.amount, p.description, p.price, " +
            "r.id AS restaurant_id, r.name AS restaurant_name, " +
            "pc.id AS category_id, pc.name AS category_name " +
            "FROM product p " +
            "JOIN restaurants r ON p.restaurant_id = r.id " +
            "JOIN product_category pc ON p.product_category_id = pc.id",
            nativeQuery = true)
    List<Object[]> findAllProducts();

    @Modifying
    @Query(value = "UPDATE Product p SET " +
            "p.name = :name, " +
            "p.amount = :amount, " +
            "p.description = :description, " +
            "p.price = :price, " +
            "p.available = :available, " +
            "p.productCategory = :productCategory WHERE p.id = :id")
    void update(Long id, String name,
                int amount, String description,
                Double price, boolean available,
                ProductCategory productCategory);



    List<Product> findAllByProductCategoryId(Long id);
    List<Product> findByRestaurantId(Long id);

}