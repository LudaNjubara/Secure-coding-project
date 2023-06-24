package com.app.healthcare.healthcare_app.repository;

import com.app.healthcare.healthcare_app.model.Facility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacilityRepository extends JpaRepository<Facility, Long> {
}
