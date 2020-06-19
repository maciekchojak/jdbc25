package pl.jdbc.models;

import java.time.LocalDate;

public class Phone {
    private final int phoneId;
    private final LocalDate manufacturedDate;
    private final int number;
    private final String model;
    private final int personId;


    private Phone(int phoneId, LocalDate manufacturedDate, int number, String model, int personId) {
        this.phoneId = phoneId;
        this.manufacturedDate = manufacturedDate;
        this.number = number;
        this.model = model;
        this.personId = personId;
    }

    public static Phone of(int phoneId, LocalDate manufacturedDate, int number, String model, int personId) {
        return new Phone(phoneId, manufacturedDate, number, model, personId);
    }

    public int getPhoneId() {
        return phoneId;
    }

    public LocalDate getManufacturedDate() {
        return manufacturedDate;
    }

    public int getNumber() {
        return number;
    }

    public String getModel() {
        return model;
    }

    public int getPersonId() {
        return personId;
    }
}