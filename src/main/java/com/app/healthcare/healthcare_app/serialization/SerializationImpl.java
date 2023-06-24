package com.app.healthcare.healthcare_app.serialization;

import com.app.healthcare.healthcare_app.dto.AppointmentDTO;
import com.app.healthcare.healthcare_app.dto.FacilityDTO;
import com.app.healthcare.healthcare_app.dto.PatientDTO;
import com.app.healthcare.healthcare_app.dto.ProviderDTO;
import com.app.healthcare.healthcare_app.model.Appointment;

public class SerializationImpl {

    private final String facilityFilePath = "serialized_data/facilitySerializedData.ser";
    private final String providerFilePath = "serialized_data/providerSerializedData.ser";
    private final String patientFilePath = "serialized_data/patientSerializedData.ser";
    private final String appointmentFilePath = "serialized_data/appointmentSerializedData.ser";
    private final String appointmentFailFilePath = "serialized_data/appointmentFailSerializedData.ser";

    public void serialize() {
        FacilityDTO facilityDTO = new FacilityDTO();
        ProviderDTO providerDTO = new ProviderDTO();
        PatientDTO patientDTO = new PatientDTO();
        AppointmentDTO appointmentDTO = new AppointmentDTO(
                10L,
                facilityDTO,
                patientDTO,
                providerDTO,
                java.time.LocalDate.now(),
                "Test Description"

        );
        Appointment appointmentFail = new Appointment();

        ObjectSerializer.serializeObject(facilityDTO, facilityFilePath);
        ObjectSerializer.serializeObject(providerDTO, providerFilePath);
        ObjectSerializer.serializeObject(patientDTO, patientFilePath);
        ObjectSerializer.serializeObject(appointmentDTO, appointmentFilePath);
        ObjectSerializer.serializeObject(appointmentFail, appointmentFailFilePath);

        System.out.println("\n");
    }

    public void deserialize() {
        FacilityDTO facilityDTO = (FacilityDTO) ObjectSerializer.deserializeObject(facilityFilePath);
        ProviderDTO providerDTO = (ProviderDTO) ObjectSerializer.deserializeObject(providerFilePath);
        PatientDTO patientDTO = (PatientDTO) ObjectSerializer.deserializeObject(patientFilePath);
        AppointmentDTO appointmentDTO = (AppointmentDTO) ObjectSerializer.deserializeObject(appointmentFilePath);
        //Appointment appointmentFail = (Appointment) ObjectSerializer.deserializeObject(appointmentFailFilePath);

        System.out.println("\n");

        System.out.println("FacilityDTO: " + facilityDTO);
        System.out.println("ProviderDTO: " + providerDTO);
        System.out.println("PatientDTO: " + patientDTO);
        System.out.println("AppointmentDTO: " + appointmentDTO);
    }
}
