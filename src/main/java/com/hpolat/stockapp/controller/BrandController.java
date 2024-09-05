package com.hpolat.stockapp.controller;

import com.hpolat.stockapp.model.Brand;
import com.hpolat.stockapp.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @GetMapping("/brands")
    public List<Brand> getAllBrands() {
        return brandService.getAllBrands();
    }

    @PostMapping("/brands")
    public Brand createBrand(@RequestBody Brand brand) {
        return brandService.createBrand(brand);
    }
}