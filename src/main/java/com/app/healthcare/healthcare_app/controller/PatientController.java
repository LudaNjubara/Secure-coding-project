package com.app.healthcare.healthcare_app.controller;

import com.app.healthcare.healthcare_app.model.Patient;
import com.app.healthcare.healthcare_app.request.PatientPostRequest;
import com.app.healthcare.healthcare_app.request.PatientPutRequest;
import com.app.healthcare.healthcare_app.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/patients")
@RestController
public class PatientController {
    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping(params = "facilityId")
    public List<Patient> getAllPatientsByFacilityId(@RequestParam Long facilityId) {
        return patientService.getAllPatientsByFacilityId(facilityId);
    }

    @GetMapping(params = "providerId")
    public List<Patient> getAllPatientsByProviderId(@RequestParam Long providerId) {
        return patientService.getAllPatientsByProviderId(providerId);
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }

    @PostMapping
    public Patient createPatient(@Valid @RequestBody PatientPostRequest patientReq) {
        return patientService.createPatient(patientReq);
    }

    @PutMapping("/{id}")
    public Patient updatePatient(@PathVariable Long id, @RequestBody PatientPutRequest patientReq) {
        return patientService.updatePatient(id, patientReq);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
    }
}
