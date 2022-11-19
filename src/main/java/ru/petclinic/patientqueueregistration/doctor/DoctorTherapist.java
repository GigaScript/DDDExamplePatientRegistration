package ru.petclinic.patientqueueregistration.doctor;

public class DoctorTherapist extends Doctor {
    public DoctorTherapist(String id, String name) {
        super(id,name, DoctorSpecialization.therapist );
    }
}
