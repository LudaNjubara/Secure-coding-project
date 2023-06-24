package com.app.healthcare.healthcare_app.repository;

import com.app.healthcare.healthcare_app.model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> {
    List<Provider> findAllByFacilityId(Long facilityId);
}
