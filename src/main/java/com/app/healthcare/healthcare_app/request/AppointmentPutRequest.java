package com.app.healthcare.healthcare_app.request;

import com.app.healthcare.healthcare_app.model.Facility;
import com.app.healthcare.healthcare_app.model.Patient;
import com.app.healthcare.healthcare_app.model.Provider;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class AppointmentPutRequest {

    @NotBlank(message = "Title cannot be blank")
    private String title;
    @NotBlank(message = "Description cannot be blank")
    private String description;
    @NotBlank(message = "Appointment date cannot be blank")
    private LocalDate appointmentDate;
    @NotNull(message = "Facility cannot be null")
    private Facility facility;
    @NotNull(message = "Provider cannot be null")
    private Provider provider;
    @NotNull(message = "Patient cannot be null")
    private Patient patient;
}
