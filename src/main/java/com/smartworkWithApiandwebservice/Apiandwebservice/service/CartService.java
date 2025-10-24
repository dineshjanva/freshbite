package com.smartworkWithApiandwebservice.Apiandwebservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartworkWithApiandwebservice.Apiandwebservice.model.Cart;
import com.smartworkWithApiandwebservice.Apiandwebservice.model.Product;
import com.smartworkWithApiandwebservice.Apiandwebservice.model.User;
import com.smartworkWithApiandwebservice.Apiandwebservice.repository.CartRepository;


import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    // public String save(Product product){
    //     return cartRepository.save(product);
    // }

    @Transactional
    public Cart addProductToCart(User userId, Product product, int quantity) {
        if (product == null) throw new IllegalArgumentException("Product must not be null");

        Long uId = userId.getId();
        Long pId = product.getId();

        Optional<Cart> existing = cartRepository.findByUser_IdAndProduct_Id(uId, pId);
        if (existing.isPresent()) {
            Cart cart = existing.get();
            cart.setQuantity(cart.getQuantity() + quantity);
            cart.setPrice(product.getPrice());
            cart.setTotalPrice(cart.getPrice() * cart.getQuantity());
            return cartRepository.save(cart);
        }

        Cart cart = new Cart();
        cart.setUser(userId);
        cart.setProduct(product);
        cart.setQuantity(quantity);
        cart.setPrice(product.getPrice());
        cart.setTotalPrice(product.getPrice() * quantity);
        return cartRepository.save(cart);
    }

    public Optional<Cart> findById(Long id) {
        return cartRepository.findById(id);
    }
    public List<Cart> findByUserId(Long userId){
        return cartRepository.findByUser_Id(userId);
    }

 public void setInc(Long id) {
    Cart cart = cartRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Cart not found"));

    cart.setQuantity(cart.getQuantity() + 1); 
    cartRepository.save(cart);
}

public void setDec(Long id) {
    Cart cart = cartRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Cart not found"));

    if (cart.getQuantity() > 1) { 
        cart.setQuantity(cart.getQuantity() - 1);
        cartRepository.save(cart);
    }
    else{
        cartRepository.deleteById(id);
    }
}


}
