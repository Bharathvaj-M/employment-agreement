package com.gorai.employment_agreement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gorai.employment_agreement.model.EmploymentAgreement;
import com.gorai.employment_agreement.service.EmploymentAgreementService;

import java.util.List;

@RestController
@RequestMapping("/api/employment-agreements")
public class EmploymentAgreementController {
    @Autowired
    private EmploymentAgreementService service;

    @PostMapping
    public ResponseEntity<EmploymentAgreement> createAgreement(@RequestBody EmploymentAgreement agreement) {
        EmploymentAgreement createdAgreement = service.createAgreement(agreement);
        return new ResponseEntity<>(createdAgreement, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmploymentAgreement> getAgreementById(@PathVariable Long id) {
        EmploymentAgreement agreement = service.getAgreementById(id);
        return ResponseEntity.ok(agreement);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmploymentAgreement> updateAgreement(@PathVariable Long id, @RequestBody EmploymentAgreement updatedAgreement) {
        EmploymentAgreement agreement = service.updateAgreement(id, updatedAgreement);
        return ResponseEntity.ok(agreement);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgreement(@PathVariable Long id) {
        service.deleteAgreement(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<EmploymentAgreement>> getAllAgreements() {
        List<EmploymentAgreement> agreements = service.getAllAgreements();
        return ResponseEntity.ok(agreements);
    }
}
