package com.smartworkWithApiandwebservice.Apiandwebservice.repository;

import com.smartworkWithApiandwebservice.Apiandwebservice.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findByUser_Id(Long userId);
    Optional<Cart> findByUser_IdAndProduct_Id(Long userId, Long productId);
}
