package com.smartworkWithApiandwebservice.Apiandwebservice.service;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.smartworkWithApiandwebservice.Apiandwebservice.repository.UserRepository;
import com.smartworkWithApiandwebservice.Apiandwebservice.model.User;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    public User findByEmail(String email){
       return userRepository.findByEmail(email);
    }

}
