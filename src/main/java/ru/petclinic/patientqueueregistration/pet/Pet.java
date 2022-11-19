package ru.petclinic.patientqueueregistration.pet;

import ru.petclinic.patientqueueregistration.visitinfo.VisitInfo;

import java.util.LinkedList;

public abstract class Pet {
    String clientId;
    String name;
    PetCategory category;
    LinkedList<VisitInfo> medicalHistory;

    public Pet(String name) {
        this.name = name;
    }

    public Pet(String clientId, String name, PetCategory category) {
        this.clientId = clientId;
        this.name = name;
        this.category = category;
    }

    public LinkedList<VisitInfo> getHistory() {
        return medicalHistory;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", category=" + category +
                ", medicalHistory=" + medicalHistory +
                '}';
    }
}
