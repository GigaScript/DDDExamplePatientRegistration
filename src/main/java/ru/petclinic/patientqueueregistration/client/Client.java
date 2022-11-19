package ru.petclinic.patientqueueregistration.client;

import ru.petclinic.patientqueueregistration.pet.Pet;

import java.util.List;
import java.util.Objects;

public abstract class Client {
    String id;
    String name;
    String phone;
    List<Pet> petsList;

    public Client(String id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public void changeName(String newName) {
        this.name = newName;
    }

    public void changePhone(String newName) {
        this.name = newName;
    }
    public String getName() {
        return name;
    }
    public String getPhone() {
        return phone;
    }
    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id.equals(client.id) && name.equals(client.name) && phone.equals(client.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phone);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", pets=" + petsList +
                '}';
    }
    public void addPet(Pet newPet) {
        petsList.add(newPet);
    }
}
