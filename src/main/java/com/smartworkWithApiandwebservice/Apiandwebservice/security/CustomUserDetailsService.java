// package com.smartworkWithApiandwebservice.Apiandwebservice.security;

// import com.smartworkWithApiandwebservice.Apiandwebservice.model.User;
// import com.smartworkWithApiandwebservice.Apiandwebservice.repository.UserRepository;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;

// @Service
// public class CustomUserDetailsService implements UserDetailsService {

//     @Autowired
//     private  UserRepository userRepository;

//     // public CustomUserDetailsService(UserRepository userRepository) {
//     //     this.userRepository = userRepository;
//     // }

//     @Override
//     public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//         User user = userRepository.findByEmail(email)
//             .orElseThrow(() -> new UsernameNotFoundException("User not found"));
//         return new CustomUserDetails(user);
//     }
// }
