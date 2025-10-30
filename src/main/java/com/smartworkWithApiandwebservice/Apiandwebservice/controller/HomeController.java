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
import com.smartworkWithApiandwebservice.Apiandwebservice.model.Offer;
import com.smartworkWithApiandwebservice.Apiandwebservice.model.Product;
import com.smartworkWithApiandwebservice.Apiandwebservice.model.User;
import com.smartworkWithApiandwebservice.Apiandwebservice.repository.OfferRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.smartworkWithApiandwebservice.Apiandwebservice.dto.OfferDTO;
// import org.springframework.web.bind.annotation.RequestParam;


// import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("api")
public class HomeController {
    
    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OfferRepository offerRepository;

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

    @PostMapping("offer")
    public String offerData(@RequestBody Offer offer) {
        // TODO: process POST request
        offerRepository.save(offer);
        return "Offer data processed successfully";
    }

    @GetMapping("alloffer")
    public List<OfferDTO> alloffer() {
       return offerRepository.findAll().stream()
        .map(o -> new OfferDTO(o.getId(), o.getTitle(), o.getDescription(), o.getDiscount(), o.getStartDate(), o.getEndDate()))
        .toList();   
    }
    @GetMapping("activeoffer")
    public List<OfferDTO> offer_active() {
        LocalDate today = LocalDate.now();
        return offerRepository.findActiveOffers(today).stream()
        .map(o -> new OfferDTO(o.getId(), o.getTitle(), o.getDescription(), o.getDiscount(), o.getStartDate(), o.getEndDate()))
        .toList();
    }
    


    
}
