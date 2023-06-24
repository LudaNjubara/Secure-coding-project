package com.app.healthcare.healthcare_app.repository;

import com.app.healthcare.healthcare_app.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
     List<Patient> findByFacilityId(Long facilityId);

    List<Patient> findByProviderId(Long providerId);
}
