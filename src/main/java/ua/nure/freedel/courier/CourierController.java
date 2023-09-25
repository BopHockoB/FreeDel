package ua.nure.freedel.courier;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/couriers")
@RequiredArgsConstructor
public class CourierController {
    private final ICourierService courierService;

    @GetMapping
    public String getUsers(Model model){
        model.addAttribute("couriers", courierService.getAllCouriers());
        return "couriers";
    }
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model){
        Courier user = courierService.findById(id);
        model.addAttribute("courier", user);
        return "update-courier";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, Courier courier){
        courierService.update(courier);
        return "redirect:/couriers?update_success";
    }
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        courierService.deleteCourier(id);
        return "redirect:/couriers?delete_success";
    }


}
