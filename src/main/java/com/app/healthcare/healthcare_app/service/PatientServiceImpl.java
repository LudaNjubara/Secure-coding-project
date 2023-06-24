package com.app.healthcare.healthcare_app.service;

import com.app.healthcare.healthcare_app.model.Patient;
import com.app.healthcare.healthcare_app.repository.FacilityRepository;
import com.app.healthcare.healthcare_app.repository.PatientRepository;
import com.app.healthcare.healthcare_app.repository.ProviderRepository;
import com.app.healthcare.healthcare_app.request.PatientPostRequest;
import com.app.healthcare.healthcare_app.request.PatientPutRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final FacilityRepository facilityRepository;
    private final ProviderRepository providerRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository, FacilityRepository facilityRepository, ProviderRepository providerRepository) {
        this.patientRepository = patientRepository;
        this.facilityRepository = facilityRepository;
        this.providerRepository = providerRepository;
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public List<Patient> getAllPatientsByFacilityId(Long facilityId) {
        return patientRepository.findByFacilityId(facilityId);
    }

    @Override
    public List<Patient> getAllPatientsByProviderId(Long providerId) {
        return patientRepository.findByProviderId(providerId);
    }

    @Override
    public Patient getPatientById(Long id) {
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        if (optionalPatient.isPresent()) {
            return optionalPatient.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient not found with that id");
        }
    }

    @Override
    public Patient createPatient(PatientPostRequest patientReq) {
        Patient newPatient = new Patient(patientReq);
        boolean isFacilityPresent = facilityRepository.findById(patientReq.getFacilityId()).isPresent();
        boolean isProviderPresent = providerRepository.findById(patientReq.getProviderId()).isPresent();

        if (isFacilityPresent && isProviderPresent) {
            newPatient.setFacility(facilityRepository.findById(patientReq.getFacilityId()).get());
            newPatient.setProvider(providerRepository.findById(patientReq.getProviderId()).get());
            return patientRepository.save(newPatient);
        }

        throw new RuntimeException("Facility or Provider not found with id: " + patientReq.getFacilityId() + " or " + patientReq.getProviderId());
    }

    @Override
    public Patient updatePatient(Long id, PatientPutRequest patientReq) {
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        if (optionalPatient.isPresent()) {
            Patient patientToUpdate = optionalPatient.get();

            patientToUpdate.setFirstName(patientReq.getFirstName());
            patientToUpdate.setLastName(patientReq.getLastName());
            patientToUpdate.setDateOfBirth(patientReq.getDateOfBirth());
            patientToUpdate.setAddress(patientReq.getAddress());
            patientToUpdate.setPhoneNumber(patientReq.getPhoneNumber());
            patientToUpdate.setFacility(patientReq.getFacility());
            patientToUpdate.setOib(patientReq.getOib());
            patientToUpdate.setImageUrl(patientReq.getImageUrl());
            patientToUpdate.setProvider(patientReq.getProvider());

            return patientRepository.save(patientToUpdate);
        } else {
            throw new RuntimeException("Patient not found with id: " + id);
        }
    }

    @Override
    @Transactional
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}
