package com.app.healthcare.healthcare_app.service;

import com.app.healthcare.healthcare_app.model.Provider;
import com.app.healthcare.healthcare_app.repository.FacilityRepository;
import com.app.healthcare.healthcare_app.repository.ProviderRepository;
import com.app.healthcare.healthcare_app.request.ProviderPostRequest;
import com.app.healthcare.healthcare_app.request.ProviderPutRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProviderServiceImpl implements ProviderService {
    private final ProviderRepository providerRepository;
    private final FacilityRepository facilityRepository;

    @Autowired
    public ProviderServiceImpl(ProviderRepository providerRepository, FacilityRepository facilityRepository) {
        this.providerRepository = providerRepository;
        this.facilityRepository = facilityRepository;
    }

    @Override
    public List<Provider> getAllProviders() {
        return providerRepository.findAll();
    }

    @Override
    public Provider getProviderById(Long id) {
        Optional<Provider> optionalProvider = providerRepository.findById(id);
        if (optionalProvider.isPresent()) {
            return optionalProvider.get();
        } else {
            throw new RuntimeException("Provider not found with id: " + id);
        }
    }

     @Override
    public List<Provider> getAllProvidersByFacilityId(Long facilityId) {
        return providerRepository.findAllByFacilityId(facilityId);
    }

    @Override
    public Provider createProvider(ProviderPostRequest providerReq) {
        Provider newProvider = new Provider(providerReq);
        boolean isFacilityPresent = facilityRepository.findById(providerReq.getFacilityId()).isPresent();

        if (isFacilityPresent) {
            newProvider.setFacility(facilityRepository.findById(providerReq.getFacilityId()).get());
            return providerRepository.save(newProvider);
        }

        throw new RuntimeException("Facility not found with id: " + providerReq.getFacilityId());
    }

    @Override
    public Provider updateProvider(Long id, ProviderPutRequest providerReq) {
        System.out.println("ProviderReq: " + providerReq);
        Optional<Provider> optionalProvider = providerRepository.findById(id);
        if (optionalProvider.isPresent()) {
            Provider providerToUpdate = optionalProvider.get();

            providerToUpdate.setFirstName(providerReq.getFirstName());
            providerToUpdate.setLastName(providerReq.getLastName());
            providerToUpdate.setAddress(providerReq.getAddress());
            providerToUpdate.setPhoneNumber(providerReq.getPhoneNumber());
            providerToUpdate.setFacility(providerReq.getFacility());
            providerToUpdate.setOib(providerReq.getOib());
            providerToUpdate.setEmail(providerReq.getEmail());
            providerToUpdate.setImageUrl(providerReq.getImageUrl());

            return providerRepository.save(providerToUpdate);
        } else {
            throw new RuntimeException("Provider not found with id: " + id);
        }
    }

    @Override
    public void deleteProvider(Long id) {
        providerRepository.deleteById(id);
    }


}
