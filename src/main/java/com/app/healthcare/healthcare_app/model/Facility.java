package com.app.healthcare.healthcare_app.model;

import com.app.healthcare.healthcare_app.request.FacilityPostRequest;
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
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    private String email;

    private String imageUrl;

    @OneToMany(mappedBy = "facility", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Provider> providers;

    @OneToMany(mappedBy = "facility", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Patient> patients;


    public Facility(String name, String address, String email) {
        this.name = name;
        this.address = address;
        this.email = email;
    }

    public Facility(FacilityPostRequest facilityReq) {
        this.name = facilityReq.getName();
        this.address = facilityReq.getAddress();
        this.email = facilityReq.getEmail();
        this.imageUrl = facilityReq.getImageUrl();
    }
}
