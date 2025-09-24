package com.example.restcontrollers;

import com.example.entities.Customer;
import com.example.entities.Product;
import com.example.projections.ProCat;
import com.example.repositories.UserRepository;
import com.example.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
@RequiredArgsConstructor
public class UserRestController {

    final UserService userService;

    @PostMapping("save")
    public Customer save(@RequestBody Customer user) {
        for (int i = 0; i < 100; i++) {
            //Random newRandom = new Random();
            //byte[] bytes = new byte[10*1024*1024];
            //String name = "Ahmet";
            //System.gc();
        }
        userService.save(user);
        //userService.findAll();
        return user;
    }

    // user login
    @PostMapping("login")
    public Customer login(@RequestBody Customer user) {
        return userService.login(user.getUsername(), user.getPassword());
    }

    @GetMapping("allPro")
    public List<Product> allPro() {
        return userService.allProducts();
    }

    @GetMapping("allProCat")
    public List<ProCat> allProCat() {
        return userService.allProCats();
    }



}
