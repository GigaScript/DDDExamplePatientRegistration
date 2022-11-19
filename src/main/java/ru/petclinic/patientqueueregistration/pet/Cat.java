package ru.petclinic.patientqueueregistration.pet;

public class Cat extends Pet{


    public Cat(String clientId, String name) {
        super(clientId, name, PetCategory.CAT);
    }
}
