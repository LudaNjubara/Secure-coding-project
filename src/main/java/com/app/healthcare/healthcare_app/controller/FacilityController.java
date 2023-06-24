package com.app.healthcare.healthcare_app.controller;

import com.app.healthcare.healthcare_app.model.Facility;
import com.app.healthcare.healthcare_app.request.FacilityPostRequest;
import com.app.healthcare.healthcare_app.request.FacilityPutRequest;
import com.app.healthcare.healthcare_app.service.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/facilities")
@RestController
public class FacilityController {
    private final FacilityService facilityService;

    @Autowired
    public FacilityController(FacilityService facilityService) {
        this.facilityService = facilityService;
    }

    @GetMapping
    public List<Facility> getAllFacilities() {
        return facilityService.getAllFacilities();
    }

//    @GetMapping("/{id}")
//    public Facility getFacilityById(@PathVariable Long id) {
//        return facilityService.getFacilityById(id);
//    }

    @GetMapping("/{name}")
    public List<Facility> getFacilityByName(@PathVariable String name) {
        return facilityService.getFacilityByName(name);
    }


    @PostMapping
    public Facility createFacility(@RequestBody FacilityPostRequest facilityReq) {
        return facilityService.createFacility(facilityReq);
    }

    @PutMapping("/{id}")
    public Facility updateFacility(@PathVariable Long id, @RequestBody FacilityPutRequest facilityReq) {
        return facilityService.updateFacility(id, facilityReq);
    }

    @DeleteMapping("/{id}")
    public void deleteFacility(@PathVariable Long id) {
        facilityService.deleteFacility(id);
    }
}
