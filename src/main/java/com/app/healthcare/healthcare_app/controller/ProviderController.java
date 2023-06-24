package com.app.healthcare.healthcare_app.controller;

import com.app.healthcare.healthcare_app.model.Provider;
import com.app.healthcare.healthcare_app.request.ProviderPostRequest;
import com.app.healthcare.healthcare_app.request.ProviderPutRequest;
import com.app.healthcare.healthcare_app.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/providers")
public class ProviderController {
    private final ProviderService providerService;

    @Autowired
    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @GetMapping
    public List<Provider> getAllProviders() {
        return providerService.getAllProviders();
    }

    @GetMapping(params = "facilityId")
    public List<Provider> getAllProvidersByFacilityId(@RequestParam Long facilityId) {
        return providerService.getAllProvidersByFacilityId(facilityId);
    }

    @GetMapping("/{id}")
    public Provider getProviderById(@PathVariable Long id) {
        return providerService.getProviderById(id);
    }

    @PostMapping
    public Provider createProvider(@Valid @RequestBody ProviderPostRequest providerReq) {
        return providerService.createProvider(providerReq);
    }

    @PutMapping("/{id}")
    public Provider updateProvider(@PathVariable Long id, @RequestBody @Valid ProviderPutRequest providerReq) {
        System.out.println("Provider in controller: " + providerReq);
        return providerService.updateProvider(id, providerReq);
    }

    @DeleteMapping("/{id}")
    public void deleteProvider(@PathVariable Long id) {
        providerService.deleteProvider(id);
    }
}
