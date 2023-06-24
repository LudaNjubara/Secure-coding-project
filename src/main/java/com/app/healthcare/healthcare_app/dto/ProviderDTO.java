package com.app.healthcare.healthcare_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProviderDTO implements Serializable {
    private Long id;
    private FacilityDTO facility;
    private List<PatientDTO> patients;
    private List<AppointmentDTO> appointments;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String email;
    private String oib;
    private String imageUrl;
}
