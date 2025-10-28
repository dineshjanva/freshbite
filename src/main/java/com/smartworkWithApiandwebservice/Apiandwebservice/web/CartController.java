package com.smartworkWithApiandwebservice.Apiandwebservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smartworkWithApiandwebservice.Apiandwebservice.service.CartService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.smartworkWithApiandwebservice.Apiandwebservice.service.OfferService;
import com.smartworkWithApiandwebservice.Apiandwebservice.model.Offer;
import com.smartworkWithApiandwebservice.Apiandwebservice.repository.OfferRepository;


@Controller
@RequestMapping("cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private OfferRepository offerRepository;

    @GetMapping("/decrement/{id}")
    public String cartInc(@PathVariable Long id) {
        cartService.setDec(id);
        return "redirect:/cart";
    }
    
    @GetMapping("/increment/{id}")
    public String cartDecre(@PathVariable Long id) {
        // System.out.println(id);
        cartService.setInc(id);
        return "redirect:/cart";
    }


    
}
