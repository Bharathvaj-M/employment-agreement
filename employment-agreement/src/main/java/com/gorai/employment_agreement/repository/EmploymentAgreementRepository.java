package com.gorai.employment_agreement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gorai.employment_agreement.model.EmploymentAgreement;

public interface EmploymentAgreementRepository extends JpaRepository<EmploymentAgreement, Long> {
    // Custom query methods if needed
}
