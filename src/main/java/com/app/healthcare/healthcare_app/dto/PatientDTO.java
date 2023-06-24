package com.app.healthcare.healthcare_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO implements Serializable {
    private Long id;
    private FacilityDTO facility;
    private ProviderDTO provider;
    private List<AppointmentDTO> appointments;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String dateOfBirth;
    private String oib;
    private String imageUrl;
}
