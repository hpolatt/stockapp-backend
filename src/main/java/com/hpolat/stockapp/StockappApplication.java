package com.hpolat.stockapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class StockappApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockappApplication.class, args);
    }

}
