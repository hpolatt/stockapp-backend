package com.hpolat.stockapp.service;

import com.hpolat.stockapp.model.CustomUserDetails;
import com.hpolat.stockapp.model.User;
import com.hpolat.stockapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    // Cache the brand by ID (e.g., cache key: "brand_<id>")
    @Override
    @Cacheable(value = "login", key = "#username")
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
    }

//    public void registerUser(String username, String password) {
//        BCryptPasswordEncoder e = new BCryptPasswordEncoder();
//        String encodedPassword = e.encode(password);
//        User newUser = new User();
//        newUser.setUsername(username);
//        newUser.setPassword(encodedPassword);
//        newUser.setEnabled(true);
//        userRepository.save(newUser);
//    }

}
