package ua.nure.freedel.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ua.nure.freedel.entities.Role;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.nure.freedel.entities.User;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/")
public class UserController {

    static List<User> users = List.of(
            new User(1, "Danylo", "+3212133123", "password", "email", Role.USER),
            new User(2, "Donut", "+321213323", "password", "email", Role.USER)
    );

    @GetMapping("all")
    public List<User> showAll(){
        return users;
    }

    @GetMapping("{id}")
    public User show(@PathVariable("id") Integer id){
        return users.get(id - 1);
    }
}
