package com.app.healthcare.healthcare_app.service;

import com.app.healthcare.healthcare_app.model.Appointment;
import com.app.healthcare.healthcare_app.repository.AppointmentRepository;
import com.app.healthcare.healthcare_app.repository.FacilityRepository;
import com.app.healthcare.healthcare_app.repository.PatientRepository;
import com.app.healthcare.healthcare_app.repository.ProviderRepository;
import com.app.healthcare.healthcare_app.request.AppointmentPostRequest;
import com.app.healthcare.healthcare_app.request.AppointmentPutRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final FacilityRepository facilityRepository;
    private final ProviderRepository providerRepository;

    @Autowired
    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, PatientRepository patientRepository, FacilityRepository facilityRepository, ProviderRepository providerRepository) {
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
        this.facilityRepository = facilityRepository;
        this.providerRepository = providerRepository;
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public List<Appointment> getAllAppointmentsByProviderId(Long providerId) {
        return appointmentRepository.getAllAppointmentsByProviderId(providerId);
    }

    @Override
    public List<Appointment> getAllAppointmentsByPatientId(Long patientId) {
        return appointmentRepository.getAllAppointmentsByPatientId(patientId);
    }

    @Override
    public Appointment getAppointmentById(Long id) {
        Optional<Appointment> optionalAppointment = appointmentRepository.findById(id);
        if (optionalAppointment.isPresent()) {
            return optionalAppointment.get();
        } else {
            throw new RuntimeException("Appointment not found with id: " + id);
        }
    }

    @Override
    public Appointment createAppointment(AppointmentPostRequest appointmentReq) {
        Appointment appointment = new Appointment(appointmentReq);
        boolean isFacilityPresent = facilityRepository  .findById(appointmentReq.getFacilityId()).isPresent();
        boolean isProviderPresent = providerRepository.findById(appointmentReq.getProviderId()).isPresent();
        boolean isPatientPresent = patientRepository.findById(appointmentReq.getPatientId()).isPresent();

        if(isFacilityPresent && isProviderPresent && isPatientPresent) {
            appointment.setFacility(facilityRepository.findById(appointmentReq.getFacilityId()).get());
            appointment.setProvider(providerRepository.findById(appointmentReq.getProviderId()).get());
            appointment.setPatient(patientRepository.findById(appointmentReq.getPatientId()).get());

            return appointmentRepository.save(appointment);
        } else {
            throw new RuntimeException("Facility or Provider or Patient not found with id: " + appointmentReq.getFacilityId() + " or " + appointmentReq.getProviderId() + " or " + appointmentReq.getPatientId());
        }
    }

    @Override
    public Appointment updateAppointment(Long id, AppointmentPutRequest appointmentReq) {
        Optional<Appointment> optionalAppointment = appointmentRepository.findById(id);

        if (optionalAppointment.isPresent()) {
            Appointment appointmentToUpdate = optionalAppointment.get();

            appointmentToUpdate.setTitle(appointmentReq.getTitle());
            appointmentToUpdate.setDescription(appointmentReq.getDescription());
            appointmentToUpdate.setAppointmentDate(appointmentReq.getAppointmentDate());
            appointmentToUpdate.setPatient(appointmentReq.getPatient());
            appointmentToUpdate.setProvider(appointmentReq.getProvider());
            appointmentToUpdate.setFacility(appointmentReq.getFacility());

            return appointmentRepository.save(appointmentToUpdate);
        } else {
            throw new RuntimeException("Appointment not found with id: " + id);
        }
    }

    @Override
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
}
