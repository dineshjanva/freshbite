package com.smartworkWithApiandwebservice.Apiandwebservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartworkWithApiandwebservice.Apiandwebservice.model.Offer_product;

@Repository
public interface Offer_ProductRepository extends JpaRepository<Offer_product, Long> {
    
}
