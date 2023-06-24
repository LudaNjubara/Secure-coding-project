package com.app.healthcare.healthcare_app.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class FacilityPostRequest {
    @NotBlank(message = "Name cannot be blank")
    private String name;
    @NotBlank(message = "Address cannot be blank")
    private String address;
    @NotBlank(message = "Email cannot be blank")
    @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Email must be valid")
    private String email;
    private String imageUrl;
}
