package ua.nure.freedel.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.nure.freedel.restaurant.IRestaurantService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping()
@RequiredArgsConstructor
public class ProductController {

    private final IProductService productService;
    private final IRestaurantService restaurantService;
    private final ProductCategoryRepository productCategoryRepository;

    @GetMapping("/restaurants/{restaurantId}")
    public String showAll(@PathVariable("restaurantId") Long id, Model model) {
        List<Product> list = productService.getAllFromRestaurant(id);
        model.addAttribute("products", list);
        model.addAttribute("restaurant", restaurantService.getById(id));
        return "products";
    }

    @GetMapping("/restaurants/{restaurantId}/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Product product = productService.getById(id);
        model.addAttribute("product", product);
        model.addAttribute("categories", productCategoryRepository.findAll());

        return "update-product";
    }

    @PostMapping("/restaurants/{restaurantId}/update/{id}")
    public String updateProduct(@PathVariable("id") Long id,
                                @PathVariable("restaurantId") Long restaurantId,
                                Product product) {
        ProductCategory productCategory = productCategoryRepository
                .findById(product.getProductCategory().getId()).get();
        product.setProductCategory(productCategory);
        product.setId(id);
        productService.update(product);
        return "redirect:/restaurants/" + restaurantId + "?update_success";
    }

    @GetMapping("/restaurants/{restaurantId}/delete/{id}")
    public String deleteRestaurant(@PathVariable("id") Long id,
                                   @PathVariable("restaurantId") Long restaurantId) {
        productService.delete(id);
        return "redirect:/restaurants/" + restaurantId + "?delete_success";
    }

    @GetMapping("/product/category/{id}")
    public String showProductByCategory(@PathVariable("id") Long id, Model model){
        List<Product> products = productService.getAllByCategoryId(id);
                products = products.stream()
                .filter(product -> product.isAvailable() &&
                        product.getRestaurant().getIsWorking())
                .collect(Collectors.toList());


        model.addAttribute("products", products);
        model.addAttribute("title", productCategoryRepository.findById(id).get().getName());
        return "product-list";
    }

    @GetMapping("/product/{id}")
    public String showProductDetails(@PathVariable("id") Long id, Model model){
        model.addAttribute("product" ,productService.getById(id));
        return "product-details";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        model.addAttribute("categories", productCategoryRepository.findAll());
        return "create-product";
    }

    @PostMapping("/create/{id}")
    public String createProduct(@PathVariable("id") Long id,
                                @PathVariable("restaurantId") Long restaurantId,
                                @ModelAttribute("product") Product product) {
        product.setAvailable(true);
        ProductCategory selectedCategory = productCategoryRepository.findById(product.getProductCategory().getId()).orElse(null);
        product.setProductCategory(selectedCategory);
        product.setRestaurant(restaurantService.getById(id));
        Product createdProduct = productService.createProduct(product);

        return "redirect:/restaurants/" + restaurantId  + "/create/" + id + "?create_success";
    }
}