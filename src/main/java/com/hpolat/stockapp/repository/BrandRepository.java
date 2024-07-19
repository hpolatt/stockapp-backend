package com.hpolat.stockapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hpolat.stockapp.model.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
}