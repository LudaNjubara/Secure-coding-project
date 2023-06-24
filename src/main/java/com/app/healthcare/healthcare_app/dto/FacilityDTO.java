package com.app.healthcare.healthcare_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FacilityDTO implements Serializable {
    private Long id;
    private List<ProviderDTO> providers;
    private List<PatientDTO> patients;
    private String name;
    private String address;
    private String email;
    private String imageUrl;
}
