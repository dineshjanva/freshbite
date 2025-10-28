package com.smartworkWithApiandwebservice.Apiandwebservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.smartworkWithApiandwebservice.Apiandwebservice.model.Offer;

@Repository
public interface OfferRepository  extends JpaRepository<Offer,Long>{
    // Custom query methods (if needed) can be defined here
} 
