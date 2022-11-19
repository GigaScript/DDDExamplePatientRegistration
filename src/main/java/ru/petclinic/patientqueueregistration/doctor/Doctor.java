package ru.petclinic.patientqueueregistration.doctor;

import java.util.Objects;

public abstract class Doctor {
    private String name;
    private String id;
    private DoctorSpecialization specialization;

    public Doctor(String id, String name, DoctorSpecialization specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public DoctorSpecialization getSpecialization() {
        return this.specialization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(name, doctor.name) && Objects.equals(id, doctor.id) && specialization == doctor.specialization;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, specialization);
    }
}
