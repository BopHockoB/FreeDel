package ua.nure.freedel.product;

import java.util.List;

public interface IProductService {
    List<Product>getAllFromRestaurant(Long restaurantId);

    Product getById(Long id);

    void update(Product product);
    void delete(Long id);
    List<Product> getAllByCategoryId(Long categoryId);
    Product createProduct(Product product);

}
