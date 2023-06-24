package com.app.healthcare.healthcare_app.model;

import com.app.healthcare.healthcare_app.request.AppointmentPostRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private LocalDate appointmentDate;

    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "facility_id")
    private Facility facility;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "provider_id")
    private Provider provider;

    public Appointment(AppointmentPostRequest appointmentReq) {
        this.title = appointmentReq.getTitle();
        this.description = appointmentReq.getDescription();
        this.appointmentDate = appointmentReq.getAppointmentDate();
    }
}
