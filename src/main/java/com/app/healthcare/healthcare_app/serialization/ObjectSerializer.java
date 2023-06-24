package com.app.healthcare.healthcare_app.serialization;

import java.io.*;

public class ObjectSerializer {

    private static final String[] WHITELISTED_CLASSES = {
        "com.app.healthcare.healthcare_app.dto.AppointmentDTO",
        "com.app.healthcare.healthcare_app.dto.FacilityDTO",
        "com.app.healthcare.healthcare_app.dto.PatientDTO",
        "com.app.healthcare.healthcare_app.dto.ProviderDTO"
    };

    public static void serializeObject(Object object, String filePath) {
        try (FileOutputStream fileOut = new FileOutputStream(filePath);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

            if (!isClassWhitelisted(object.getClass())) {
                throw new IllegalArgumentException("Class " + object.getClass().getSimpleName() + " is not whitelisted for serialization.");
            }

            out.writeObject(object);
            System.out.println("Object " + object.getClass().getSimpleName() + " serialized successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object deserializeObject(String filePath) {
        try (FileInputStream fileIn = new FileInputStream(filePath);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {

            Object deserializedObject = in.readObject();

            if (!isClassWhitelisted(deserializedObject.getClass())) {
                throw new IllegalArgumentException("Class " + deserializedObject.getClass().getSimpleName() + " is not whitelisted for deserialization.");
            }

            System.out.println("Object " + deserializedObject.getClass().getSimpleName() + " deserialized successfully.");
            return deserializedObject;

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static boolean isClassWhitelisted(Class<?> clazz) {
        String className = clazz.getName();
        for (String whitelistedClass : WHITELISTED_CLASSES) {
            if (className.equals(whitelistedClass)) {
                return true;
            }
        }
        return false;
    }
}

