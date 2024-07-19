package com.hpolat.stockapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hpolat.stockapp.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
