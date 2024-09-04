package com.hpolat.stockapp.model;

import javax.persistence.*;

@Entity
@Table(name = "brands")
public class Brand extends DefineModel {
    private String email;

    private String address;

    private String phone;

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
