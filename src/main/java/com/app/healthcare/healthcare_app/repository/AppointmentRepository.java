package com.app.healthcare.healthcare_app.repository;

import com.app.healthcare.healthcare_app.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> getAllAppointmentsByProviderId(Long providerId);

    List<Appointment> getAllAppointmentsByPatientId(Long patientId);
    
    boolean existsByPatientId(Long patientId);

    void deleteAllByPatientId(Long id);
}
