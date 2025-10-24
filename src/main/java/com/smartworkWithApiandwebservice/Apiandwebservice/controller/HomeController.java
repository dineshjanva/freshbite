package com.smartworkWithApiandwebservice.Apiandwebservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import com.smartworkWithApiandwebservice.Apiandwebservice.service.ProductService;
import com.smartworkWithApiandwebservice.Apiandwebservice.service.UserService;
import com.smartworkWithApiandwebservice.Apiandwebservice.model.Product;
import com.smartworkWithApiandwebservice.Apiandwebservice.model.User;

import java.util.List;
import java.util.Map;




@RestController
@RequestMapping("api")
public class HomeController {
    
    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    // @GetMapping
    // public String home() {
    //     return "Hello";
    // }

    @GetMapping("/users")
    public Map<String,Object> listUsers() {
        List<User> list = userService.getAllUser();
        String message =(list.isEmpty()) ? "No user Found":"User fetch success"; 
        return Map.of(
            "message",message,
            "data",list); 
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // @PostMapping("/users")
    // public ResponseEntity<User> createUser(@RequestBody User user) {
    //     User created = userService.createUser(user);
    //     return ResponseEntity.created(java.net.URI.create("/users/" + created.getId())).body(created);
    // }

    @GetMapping("allproducts")
    public List<Product> product() {
        return productService.findAll();
    }
    
    
}
