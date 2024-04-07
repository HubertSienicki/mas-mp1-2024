package org.example.driver;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.io.Serializable;

@Getter
public class Driver implements Serializable {
    @NonNull
    @Setter
    private String firstname; // Required attribute

    private int age; // Required attribute

    @NonNull
    @Setter
    private String lastname; // Required attribute

    public Driver(@NonNull String firstname, int age, @NonNull String lastname) {
        if (firstname.isEmpty()) throw new IllegalArgumentException("First name cannot be empty");
        if (lastname.isEmpty()) throw new IllegalArgumentException("Last name cannot be empty");
        if (age <= 0) throw new IllegalArgumentException("Age cannot be negative or equal to zero");

        this.firstname = firstname;
        this.age = age;
        this.lastname = lastname;
    }

    public String getFullName() {
        return firstname + " " + lastname; // Composed attribute
    }

    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age cannot be negative or equal to zero");
        }
        this.age = age;
    }
}
