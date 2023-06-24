package com.app.healthcare.healthcare_app.service;

import com.app.healthcare.healthcare_app.model.Provider;
import com.app.healthcare.healthcare_app.request.ProviderPostRequest;
import com.app.healthcare.healthcare_app.request.ProviderPutRequest;

import java.util.List;

public interface ProviderService {
    List<Provider> getAllProviders();

    Provider getProviderById(Long id);

    Provider createProvider(ProviderPostRequest providerReq);

    Provider updateProvider(Long id, ProviderPutRequest providerReq);

    void deleteProvider(Long id);

    List<Provider> getAllProvidersByFacilityId(Long facilityId);
}
