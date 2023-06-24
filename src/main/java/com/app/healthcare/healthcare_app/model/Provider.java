package com.app.healthcare.healthcare_app.model;

import com.app.healthcare.healthcare_app.request.ProviderPostRequest;
import com.app.healthcare.healthcare_app.request.ProviderPutRequest;
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
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "facility_id")
    private Facility facility;

    @OneToMany(mappedBy = "provider", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Patient> patients;

    @OneToMany(mappedBy = "provider", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Appointment> appointments;

    private String firstName;

    private String lastName;

    private String address;

    private String phoneNumber;

    private String email;

    private String oib;

    private String imageUrl;

    public Provider(ProviderPostRequest providerRequest) {
        this.firstName = providerRequest.getFirstName();
        this.lastName = providerRequest.getLastName();
        this.address = providerRequest.getAddress();
        this.phoneNumber = providerRequest.getPhoneNumber();
        this.email = providerRequest.getEmail();
        this.oib = providerRequest.getOib();
        this.imageUrl = providerRequest.getImageUrl();
    }

    public Provider(ProviderPutRequest providerRequest) {
        this.facility = providerRequest.getFacility();
        this.firstName = providerRequest.getFirstName();
        this.lastName = providerRequest.getLastName();
        this.address = providerRequest.getAddress();
        this.phoneNumber = providerRequest.getPhoneNumber();
        this.email = providerRequest.getEmail();
        this.oib = providerRequest.getOib();
        this.imageUrl = providerRequest.getImageUrl();
    }
}