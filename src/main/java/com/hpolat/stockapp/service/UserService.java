package com.hpolat.stockapp.service;

import com.hpolat.stockapp.model.CustomUserDetails;
import com.hpolat.stockapp.model.User;
import com.hpolat.stockapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService
{
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
    }

    public void registerUser(String username, String password) {
        BCryptPasswordEncoder e = new BCryptPasswordEncoder();
        String encodedPassword = e.encode(password);
        User newUser = new User(username, encodedPassword, true);
        userRepository.save(newUser);
    }

}
