package com.app.healthcare.healthcare_app.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class PatientPostRequest {

    @NotNull(message = "Facility ID cannot be null")
    private Long facilityId;

    @NotNull(message = "Provider ID cannot be null")
    private Long providerId;

    @NotBlank(message = "First name cannot be blank")
    @Pattern(regexp = "^[a-zA-Z]{2,}$", message = "First name must contain only letters and be at least 2 characters long")
    private String firstName;

    @NotBlank(message = "Last name cannot be blank")
    @Pattern(regexp = "^[a-zA-Z]{2,}$", message = "Last name must contain only letters and be at least 2 characters long")
    private String lastName;

    @NotBlank(message = "Address cannot be blank")
    private String address;

    @NotBlank(message = "Phone number cannot be blank")
    @Pattern(regexp = "^[0-9]{9,10}$", message = "Phone number must contain only numbers and be between 9 and 10 characters long")
    private String phoneNumber;

    // date of birth
    @NotBlank(message = "Date of birth cannot be blank")
    private String dateOfBirth;

    @NotBlank(message = "OIB cannot be blank")
    @Pattern(regexp = "^[0-9]{11}$", message = "OIB must contain only numbers and be 11 characters long")
    private String oib;

    @NotBlank(message = "Image URL cannot be blank")
    private String imageUrl;


}
