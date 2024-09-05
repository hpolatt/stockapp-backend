package com.hpolat.stockapp.service;

import com.hpolat.stockapp.model.Brand;
import com.hpolat.stockapp.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    @Autowired
    BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    // Cache the list of brands (e.g., cache key: "allBrands")
    @Cacheable(value = "brandsCache", key = "'allBrands'")
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    // Cache the brand by ID (e.g., cache key: "brand_<id>")
    @Cacheable(value = "brandsCache", key = "#id")
    public Brand getBrandById(Long id) {
        return brandRepository.findById(id).orElseThrow(() -> new RuntimeException("Brand not found"));
    }

    // Invalidate "allBrands" cache when a new brand is created
    @CacheEvict(value = "brandsCache", key = "'allBrands'", allEntries = true)
    public Brand createBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    // Combine CachePut and CacheEvict using @Caching
    @Caching(
            put = { @CachePut(value = "brandsCache", key = "#id") },
            evict = { @CacheEvict(value = "brandsCache", key = "'allBrands'", allEntries = true) }
    )
    public Brand updateBrand(Long id, Brand brandDetails) {
        Brand brand = getBrandById(id);
        brand.setName(brandDetails.getName());
        return brandRepository.save(brand);
    }

    // Combine multiple cache evictions for delete operation
    @Caching(
            evict = {
                    @CacheEvict(value = "brandsCache", key = "#id"), // Evict cache for the specific brand
                    @CacheEvict(value = "brandsCache", key = "'allBrands'", allEntries = true) // Evict cache for all brands
            }
    )
    public void deleteBrand(Long id) {
        brandRepository.deleteById(id);
    }
}
