package com.gorai.employment_agreement.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gorai.employment_agreement.model.EmploymentAgreement;
import com.gorai.employment_agreement.repository.EmploymentAgreementRepository;
import com.gorai.employment_agreement.exception.ResourceNotFoundException;

import java.util.List;

@Service
public class EmploymentAgreementService {
    @Autowired
    private EmploymentAgreementRepository repository;

    public EmploymentAgreement createAgreement(EmploymentAgreement agreement) {
        return repository.save(agreement);
    }

    public EmploymentAgreement getAgreementById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Agreement not found"));
    }

    public List<EmploymentAgreement> getAllAgreements() {
        return repository.findAll();
    }

    public EmploymentAgreement updateAgreement(Long id, EmploymentAgreement updatedAgreement) {
        EmploymentAgreement agreement = getAgreementById(id);
        agreement.setEmployeeName(updatedAgreement.getEmployeeName());
        agreement.setRole(updatedAgreement.getRole());
        agreement.setStartDate(updatedAgreement.getStartDate());
        agreement.setEndDate(updatedAgreement.getEndDate());
        agreement.setSalary(updatedAgreement.getSalary());
        agreement.setTerms(updatedAgreement.getTerms());
        agreement.setOtherDetails(updatedAgreement.getOtherDetails());
        return repository.save(agreement);
    }

    public void deleteAgreement(Long id) {
        repository.deleteById(id);
    }
}
