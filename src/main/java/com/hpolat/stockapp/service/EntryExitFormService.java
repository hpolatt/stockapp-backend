package com.hpolat.stockapp.service;

import com.hpolat.stockapp.model.EntryExitForm;
import com.hpolat.stockapp.repository.EntryExitFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntryExitFormService {

    @Autowired
    private EntryExitFormRepository entryExitFormRepository;

    public List<EntryExitForm> getAllEntryExitForms() {
        return entryExitFormRepository.findAll();
    }

    public EntryExitForm getEntryExitFormById(Long id) {
        return entryExitFormRepository.findById(id).orElseThrow(() -> new RuntimeException("EntryExitForm not found"));
    }

    public EntryExitForm createEntryExitForm(EntryExitForm entryExitForm) {
        return entryExitFormRepository.save(entryExitForm);
    }

    public EntryExitForm updateEntryExitForm(Long id, EntryExitForm entryExitFormDetails) {
        EntryExitForm entryExitForm = getEntryExitFormById(id);
        entryExitForm.setType(entryExitFormDetails.getType());
        entryExitForm.setDate(entryExitFormDetails.getDate());
        entryExitForm.setQuantity(entryExitFormDetails.getQuantity());
        entryExitForm.setProduct(entryExitFormDetails.getProduct());
        entryExitForm.setStore(entryExitFormDetails.getStore());
        return entryExitFormRepository.save(entryExitForm);
    }

    public void deleteEntryExitForm(Long id) {
        entryExitFormRepository.deleteById(id);
    }
}
