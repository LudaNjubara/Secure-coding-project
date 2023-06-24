package com.app.healthcare.healthcare_app.service;

import com.app.healthcare.healthcare_app.model.Appointment;
import com.app.healthcare.healthcare_app.request.AppointmentPostRequest;
import com.app.healthcare.healthcare_app.request.AppointmentPutRequest;

import java.util.List;

public interface AppointmentService {
    List<Appointment> getAllAppointments();

    List<Appointment> getAllAppointmentsByProviderId(Long providerId);

    List<Appointment> getAllAppointmentsByPatientId(Long patientId);

    Appointment getAppointmentById(Long id);

    Appointment createAppointment(AppointmentPostRequest appointmentReq);

    Appointment updateAppointment(Long id, AppointmentPutRequest appointmentReq);

    void deleteAppointment(Long id);


}
