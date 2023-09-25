package ua.nure.freedel.restaurant;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/restaurants")
public class RestaurantController {

    private final IRestaurantService restaurantService;
    private final RestaurantCategoryRepository restaurantCategoryRepository;

    @GetMapping()
    public String showAll(Model model) {
        model.addAttribute("restaurants", restaurantService.getAllRestaurants());
        return "restaurants";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model){

        model.addAttribute("restaurant", restaurantService.getById(id));
        model.addAttribute("categories", restaurantCategoryRepository.findAll());
        return "update-restaurant";
    }
    @PostMapping("/update/{id}")
    public String updateRestaurant(@PathVariable("id") Long id, Restaurant restaurant){
        restaurant.setId(id);
        restaurantService.update(restaurant);
        return "redirect:/restaurants?update_success";
    }

    @GetMapping("/delete/{id}")
    public String deleteRestaurant(@PathVariable("id") Long id){
        restaurantService.deleteRestaurant(id);
        return "redirect:/restaurants?delete_success";
    }
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        Restaurant restaurant = new Restaurant();
        model.addAttribute("restaurant", restaurant);
        model.addAttribute("categories", restaurantCategoryRepository.findAll());
        return "create-restaurant";
    }

    @PostMapping("/create")
    public String createRestaurant(@ModelAttribute("restaurant") Restaurant restaurant) {
        restaurant.setRate(0.0);
        restaurant.setIsWorking(true);
        RestaurantCategory selectedCategory = restaurantCategoryRepository.findById(restaurant.getRestaurantCategory().getId()).orElse(null);
        restaurant.setRestaurantCategory(selectedCategory);
        Restaurant createdRestaurant = restaurantService.createRestaurant(restaurant);

        if (createdRestaurant != null) {
            return "redirect:/restaurants/" + createdRestaurant.getId() + "?create_success";
        } else {
            return "redirect:/error";
        }
    }

}
