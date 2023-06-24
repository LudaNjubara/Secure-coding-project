package com.app.healthcare.healthcare_app.service;

import com.app.healthcare.healthcare_app.model.Patient;
import com.app.healthcare.healthcare_app.request.PatientPostRequest;
import com.app.healthcare.healthcare_app.request.PatientPutRequest;

import java.util.List;

public interface PatientService {
    List<Patient> getAllPatients();

    List<Patient> getAllPatientsByFacilityId(Long facilityId);

    List<Patient> getAllPatientsByProviderId(Long providerId);


    Patient getPatientById(Long id);

    Patient createPatient(PatientPostRequest patientReq);

    Patient updatePatient(Long id, PatientPutRequest patientReq);

    void deletePatient(Long id);

}
