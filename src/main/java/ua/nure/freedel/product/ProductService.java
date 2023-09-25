package ua.nure.freedel.product;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.nure.freedel.restaurant.Restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {
    private final ProductRepository productRepository;

    public List<Product> getAllFromRestaurant(Long RestaurantId) {
        return productRepository.findByRestaurantId(RestaurantId);
    }

    public Product getById(Long id) {
        return productRepository.findById(id).get();
    }

    @Transactional
    public void update(Product product) {
        productRepository.update(product.getId(), product.getName(),
                product.getAmount(), product.getDescription(),
                product.getPrice(), product.isAvailable(),
                product.getProductCategory());
    }

    @Transactional
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> getAllByCategoryId(Long id) {
        return productRepository.findAllByProductCategoryId(id);
    }
    public Product createProduct(Product product) {
        Product createdProduct = productRepository.save(product);
        return createdProduct;
    }
    public List<Product> getAllProducts() {
        List<Object[]> results = productRepository.findAllProducts();


        return parceToProducts(results);
    }

    private List<Product> parceToProducts(List<Object[]> results) {
        List<Product> products = new ArrayList<>();

        for (Object[] result : results) {
            Long productId = (Long) result[0];
            String productName = (String) result[1];
            int productAmount = (int) result[2];
            String productDescription = (String) result[3];
            Double productPrice = (Double) result[4];

            Long restaurantId = (Long) result[5];
            String restaurantName = (String) result[6];
            Restaurant restaurant = Restaurant.builder()
                    .build();

            Long categoryId = (Long) result[7];
            String categoryName = (String) result[8];
            ProductCategory productCategory = new ProductCategory(categoryId, categoryName);

            Product product = new Product(productId, productName, productAmount, productDescription,
                    productPrice, restaurant, true, productCategory);
            products.add(product);
        }
        return products;
    }
}
