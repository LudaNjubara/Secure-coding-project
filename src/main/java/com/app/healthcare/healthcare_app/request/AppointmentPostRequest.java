package com.app.healthcare.healthcare_app.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class AppointmentPostRequest {
    @NotBlank(message = "Title cannot be blank")
    private String title;
    @NotBlank(message = "Description cannot be blank")
    private String description;
    @NotNull(message = "Appointment date cannot be blank")
    private LocalDate appointmentDate;
    @NotNull(message = "Provider id cannot be null")
    private Long providerId;
    @NotNull(message = "Patient id cannot be null")
    private Long patientId;
    @NotNull(message = "Facility id cannot be null")
    private Long facilityId;

}
