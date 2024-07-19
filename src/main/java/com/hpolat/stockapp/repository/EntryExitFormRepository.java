package com.hpolat.stockapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hpolat.stockapp.model.EntryExitForm;

@Repository
public interface EntryExitFormRepository extends JpaRepository<EntryExitForm, Long> {
}
