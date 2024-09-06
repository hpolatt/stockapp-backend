package com.hpolat.stockapp.controller;

import com.hpolat.stockapp.model.AuthenticationRequest;
import com.hpolat.stockapp.config.JwtUtil;
import com.hpolat.stockapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/login")
@Validated
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userDetailsService;

    @PostMapping
    public ResponseEntity<Map<String, Object>>  createAuthenticationToken(@Valid @RequestBody AuthenticationRequest authRequest) throws Exception {
        Map<String, Object> response = new HashMap<>();
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "Incorrect username or password");
            response.put("timestamp", new Date().toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }


        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails.getUsername());

        response.put("timestamp", new Date().toString());
        response.put("success", true);
        response.put("token", jwt);
        return ResponseEntity.ok(response);
    }
}
