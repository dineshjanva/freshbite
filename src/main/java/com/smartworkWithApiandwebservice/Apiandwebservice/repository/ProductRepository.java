package com.smartworkWithApiandwebservice.Apiandwebservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartworkWithApiandwebservice.Apiandwebservice.model.Product;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product ,Long>{   
  List<Product> findTop5ByOrderByCreatedAtDesc();
}
