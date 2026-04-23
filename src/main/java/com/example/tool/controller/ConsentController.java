// Day 3 completed - Service layer added
package com.example.tool.controller;

import com.example.tool.entity.Consent;
import com.example.tool.service.ConsentService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consents")
public class ConsentController {

    private final ConsentService service;

    public ConsentController(ConsentService service) {
        this.service = service;
    }

    // ✅ CREATE
    @PostMapping
    public Consent create(@RequestBody Consent consent) {
        return service.createConsent(consent);
    }

    // ✅ GET ALL
    @GetMapping
    public List<Consent> getAll() {
        return service.getAllConsents();
    }

    // ✅ GET BY ID
    @GetMapping("/{id}")
    public Consent getById(@PathVariable Long id) {
        return service.getConsentById(id);
    }

    // ✅ UPDATE
    @PutMapping("/{id}")
    public Consent update(@PathVariable Long id, @RequestBody Consent consent) {
        return service.updateConsent(id, consent);
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteConsent(id);
        return "Deleted successfully";
    }
}