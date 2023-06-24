package com.app.healthcare.healthcare_app.service;

import com.app.healthcare.healthcare_app.model.Facility;
import com.app.healthcare.healthcare_app.request.FacilityPostRequest;
import com.app.healthcare.healthcare_app.request.FacilityPutRequest;

import java.util.List;

public interface FacilityService {
    List<Facility> getAllFacilities();

    Facility getFacilityById(Long id);

    Facility createFacility(FacilityPostRequest facilityReq);

    Facility updateFacility(Long id, FacilityPutRequest facilityReq);

    void deleteFacility(Long id);

    List<Facility> getFacilityByName(String name);
}
