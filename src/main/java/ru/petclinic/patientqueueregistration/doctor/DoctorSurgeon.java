package ru.petclinic.patientqueueregistration.doctor;

public class DoctorSurgeon extends Doctor {
    public DoctorSurgeon(String id, String name) {
        super(id, name, DoctorSpecialization.surgeon);
    }
}
