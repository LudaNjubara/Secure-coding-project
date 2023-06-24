package com.app.healthcare.healthcare_app.model;

import com.app.healthcare.healthcare_app.request.PatientPostRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "facility_id")
    private Facility facility;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "provider_id")
    private Provider provider;

    @OneToMany(mappedBy = "patient", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Appointment> appointments;

    private String address;

    private String phoneNumber;

    private String dateOfBirth;

    private String oib;

    private String imageUrl;

      public Patient(PatientPostRequest patientRequest) {
        this.firstName = patientRequest.getFirstName();
        this.lastName = patientRequest.getLastName();
        this.address = patientRequest.getAddress();
        this.phoneNumber = patientRequest.getPhoneNumber();
        this.dateOfBirth = patientRequest.getDateOfBirth();
        this.oib = patientRequest.getOib();
        this.imageUrl = patientRequest.getImageUrl();
    }
}
