package com.hpolat.stockapp.controller;

import com.hpolat.stockapp.model.EntryExitForm;
import com.hpolat.stockapp.service.EntryExitFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entry-exit-forms")
public class EntryExitFormController {

    @Autowired
    private EntryExitFormService entryExitFormService;

    @GetMapping
    public List<EntryExitForm> getAllEntryExitForms() {
        return entryExitFormService.getAllEntryExitForms();
    }

    @PostMapping
    public EntryExitForm createEntryExitForm(@RequestBody EntryExitForm entryExitForm) {
        return entryExitFormService.createEntryExitForm(entryExitForm);
    }

    @GetMapping("/{id}")
    public EntryExitForm getProductById(@PathVariable Long id) {
        return entryExitFormService.getEntryExitFormById(id);
    }

    @PutMapping("/{id}")
    public EntryExitForm updateProduct(@PathVariable Long id, @RequestBody EntryExitForm entryExitForm) {
        return entryExitFormService.updateEntryExitForm(id, entryExitForm);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        entryExitFormService.deleteEntryExitForm(id);
    }
}
