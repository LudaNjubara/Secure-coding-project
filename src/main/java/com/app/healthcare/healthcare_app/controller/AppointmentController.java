package com.app.healthcare.healthcare_app.controller;

import com.app.healthcare.healthcare_app.model.Appointment;
import com.app.healthcare.healthcare_app.request.AppointmentPostRequest;
import com.app.healthcare.healthcare_app.request.AppointmentPutRequest;
import com.app.healthcare.healthcare_app.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @GetMapping(params = "providerId")
    public List<Appointment> getAllAppointmentsByProviderId(@RequestParam Long providerId) {
        return appointmentService.getAllAppointmentsByProviderId(providerId);
    }

    @GetMapping(params = "patientId")
    public List<Appointment> getAllAppointmentsByPatientId(@RequestParam Long patientId) {
        return appointmentService.getAllAppointmentsByPatientId(patientId);
    }

    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable Long id) {
        return appointmentService.getAppointmentById(id);
    }

    @PostMapping
    public Appointment createAppointment(@RequestBody AppointmentPostRequest appointmentReq) {
        return appointmentService.createAppointment(appointmentReq);
    }

    @PutMapping("/{id}")
    public Appointment updateAppointment(@PathVariable Long id, @RequestBody AppointmentPutRequest appointmentReq) {
        return appointmentService.updateAppointment(id, appointmentReq);
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        //jmsTemplate.convertAndSend("appointmentQueue", "Deleted appointment with ID: " + id);
    }
}

