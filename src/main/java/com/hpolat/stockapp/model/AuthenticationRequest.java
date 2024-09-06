package com.hpolat.stockapp.model;

import com.sun.istack.NotNull;
import org.hibernate.annotations.NotFound;

import javax.validation.constraints.NotBlank;

public class AuthenticationRequest {

    @NotBlank(message = "username is required")
    private String username;

    @NotBlank(message = "password is required")
    private String password;

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
