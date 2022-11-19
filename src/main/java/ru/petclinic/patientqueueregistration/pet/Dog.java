package ru.petclinic.patientqueueregistration.pet;

public class Dog extends Pet{
    public Dog(String clientId, String name) {
        super(clientId, name, PetCategory.DOG);
    }
}
