package ru.csc.java.networking.serialization;

import java.io.Serializable;

public class SerializablePerson implements Serializable {

    private static final long serialVersionUID = 44444444;

    private String firstName;
    private String lastName;

    public SerializablePerson(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
