package com.hpolat.stockapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hpolat.stockapp.model.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
}
