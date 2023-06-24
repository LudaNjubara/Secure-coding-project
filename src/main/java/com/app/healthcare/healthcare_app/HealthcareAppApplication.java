package com.app.healthcare.healthcare_app;

import com.app.healthcare.healthcare_app.serialization.SerializationImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
//        exclude = {SecurityAutoConfiguration.class}
)
public class HealthcareAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthcareAppApplication.class, args);

        // Serialization and Deserialization
        serializeData();
        deserializeData();
    }

    private static void serializeData() {
        SerializationImpl serializer = new SerializationImpl();
        serializer.serialize();
    }

    private static void deserializeData() {
        SerializationImpl deserializer = new SerializationImpl();
        deserializer.deserialize();
    }

}
