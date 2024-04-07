package org.example.racecar;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import org.example.driver.Driver;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@ToString
public class RaceCar implements Serializable {
    private static final List<RaceCar> raceCarExtension = new ArrayList<>(); // raceCar extension

      @Getter
    private static String manufacturer = "Porsche"; // Class attribute
    private final List<Driver> drivers = new ArrayList<>(); // Repeatable and optional attribute

    @NonNull
    @Getter
    @Setter
    private String model; // Required attribute

    @Getter
    private double horsePower; // Required attribute type of Integer

    @Getter
    @Setter
    private String carName; // Optional attribute

    // Constructors
    public RaceCar(@NonNull String model, double horsePower) {
        if (model.isEmpty()) throw new IllegalArgumentException("Model cannot be empty");
        this.model = model;
        if (horsePower < 0) throw new IllegalArgumentException("Horse power cannot be negative");
        if (horsePower > 1000) throw new IllegalArgumentException("Horse power cannot be greater than 1000");
        this.horsePower = horsePower;
        raceCarExtension.add(this);
    }

    public RaceCar(@NonNull String model, double horsePower, List<Driver> drivers) {
        if (model.isEmpty()) throw new IllegalArgumentException("Model cannot be empty");
        this.model = model;
        if (horsePower < 0) throw new IllegalArgumentException("Horse power cannot be negative");
        if (horsePower > 1000) throw new IllegalArgumentException("Horse power cannot be greater than 1000");
        this.horsePower = horsePower;
        this.drivers.addAll(drivers);
        raceCarExtension.add(this);
    }

    public RaceCar(@NonNull String model, double horsePower, String carName) {
        if (model.isEmpty()) throw new IllegalArgumentException("Model cannot be empty");
        this.model = model;

        if (horsePower < 0) throw new IllegalArgumentException("Horse power cannot be negative");
        if (horsePower > 1000) throw new IllegalArgumentException("Horse power cannot be greater than 1000");
        this.horsePower = horsePower;

        this.carName = carName;
        raceCarExtension.add(this);
    }

    public RaceCar(@NonNull String model, double horsePower, String carName, List<Driver> drivers) {
        if (model.isEmpty()) throw new IllegalArgumentException("Model cannot be empty");
        this.model = model;
        if (horsePower < 0) throw new IllegalArgumentException("Horse power cannot be negative");
        if (horsePower > 1000) throw new IllegalArgumentException("Horse power cannot be greater than 1000");
        this.horsePower = horsePower;
        this.carName = carName;
        this.drivers.addAll(drivers);
    }

    // receiving extension
    public static @NonNull List<RaceCar> getExtension() {
        return Collections.unmodifiableList(raceCarExtension);
    }

    public boolean setHorsePower(double horsePower) {
        if (horsePower < 0) {
            throw new IllegalArgumentException("Horse power cannot be negative");
        }
        if(horsePower > 1000) throw new IllegalArgumentException("Horse power cannot be greater than 1000");
        this.horsePower = horsePower;
        return true;
    }

    public boolean addDriver(@NonNull Driver driver) {
        return drivers.add(driver);
    }

    public boolean removeDriver(Driver driver) {
        return drivers.remove(driver);
    }

    public double calculateKilowatts() { // Derived attribute
        return horsePower * 0.735499;
    }

    public Collection<Object> getDrivers() {
        return Collections.unmodifiableList(drivers);
    }
}