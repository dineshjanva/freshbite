package com.smartworkWithApiandwebservice.Apiandwebservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smartworkWithApiandwebservice.Apiandwebservice.repository.ProductRepository;
import com.smartworkWithApiandwebservice.Apiandwebservice.model.*;
import java.util.*;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }
    public Product save(Product product){
        return productRepository.save(product);
    }
    public List<Product> top4(){
        return productRepository.findTop5ByOrderByCreatedAtDesc();
    }

    public Product findById(Long id){
        return productRepository.findById(id).orElse(null);
    }
}
