package com.smartworkWithApiandwebservice.Apiandwebservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// import java.util.Optional;

import com.smartworkWithApiandwebservice.Apiandwebservice.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email); 
}
