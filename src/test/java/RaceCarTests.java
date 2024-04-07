import org.example.driver.Driver;
import org.example.racecar.RaceCar;
import org.example.racecar.RaceCarPersistance;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RaceCarTests {

    @DisplayName("Smoke test")
    @Test
    void smokeTest() {}

    // Constructor tests
    @DisplayName("Test if the RaceCar class has a constructor with the required attributes")
    @Test
    void testRaceCarRequiredAttributes() {
        // Given
        String model = "911 GT3";
        double horsePower = 500;

        // When
        RaceCar raceCar = new RaceCar(model, horsePower);

        // Then
        assertEquals(model, raceCar.getModel());
        assertEquals(horsePower, raceCar.getHorsePower());
    }

    @DisplayName("Test exception when horse power is greater than 1000")
    @Test
    void testRaceCarHorsePowerGreaterThan1000() {
        // Given
        String model = "911 GT3";
        double horsePower = 1500;

        // When
        try {
            RaceCar raceCar = new RaceCar(model, horsePower);
        } catch (IllegalArgumentException e) {
            // Then
            assertEquals("Horse power cannot be greater than 1000", e.getMessage());
        }
    }

    @DisplayName("Test exception when the horse power is negative only with the required attributes")
    @Test
    void testRaceCarNegativeHorsePower() {
        // Given
        String model = "911 GT3";
        double horsePower = -500;

        // When
        try {
            RaceCar raceCar = new RaceCar(model, horsePower);
        } catch (IllegalArgumentException e) {
            // Then
            assertEquals("Horse power cannot be negative", e.getMessage());
        }
    }

    @DisplayName("Test exception when model is null")
    @Test
    void testRaceCarNullModel() {
        double horsePower = 500;

        // When
        try {
            RaceCar raceCar = new RaceCar(null, horsePower);
        } catch (NullPointerException e) {
            // Then
            assertEquals("model is marked non-null but is null", e.getMessage());
        }
    }

    @DisplayName("Test exception when model is empty")
    @Test
    void testRaceCarEmptyModel() {
        double horsePower = 500;

        // When
        try {
            RaceCar raceCar = new RaceCar("", horsePower);
        } catch (IllegalArgumentException e) {
            // Then
            assertEquals("Model cannot be empty", e.getMessage());
        }
    }

    @DisplayName("Test if the RaceCar class has a constructor with the required and optional attributes")
    @Test
    void testRaceCarRequiredAndOptionalAttributes() {
        // Given
        String model = "911 GT3";
        double horsePower = 500;
        String carName = "Porsche 911 GT3";

        // When
        RaceCar raceCar = new RaceCar(model, horsePower, carName);

        // Then
        assertEquals(model, raceCar.getModel());
        assertEquals(horsePower, raceCar.getHorsePower());
        assertEquals(carName, raceCar.getCarName());
    }

    @DisplayName("Test exception when the horse power is negative with the required and optional attributes")
    @Test
    void testRaceCarNegativeHorsePowerRequiredAndOptionalAttributes() {
        // Given
        String model = "911 GT3";
        double horsePower = -500;
        String carName = "Porsche 911 GT3";

        // When
        try {
            RaceCar raceCar = new RaceCar(model, horsePower, carName);
        } catch (IllegalArgumentException e) {
            // Then
            assertEquals("Horse power cannot be negative", e.getMessage());
        }
    }

    @DisplayName("Test exception when the horse power is greater than 1000 with the required and optional attributes")
    @Test
    void testRaceCarHorsePowerGreaterThan1000RequiredAndOptionalAttributes() {
        // Given
        String model = "911 GT3";
        double horsePower = 1500;
        String carName = "Porsche 911 GT3";

        // When
        try {
            RaceCar raceCar = new RaceCar(model, horsePower, carName);
        } catch (IllegalArgumentException e) {
            // Then
            assertEquals("Horse power cannot be greater than 1000", e.getMessage());
        }
    }

    @DisplayName("Test exception when model is null with the required and optional attributes")
    @Test
    void testRaceCarNullModelRequiredAndOptionalAttributes() {
        double horsePower = 500;
        String carName = "Porsche 911 GT3";

        // When
        try {
            RaceCar raceCar = new RaceCar(null, horsePower, carName);
        } catch (NullPointerException e) {
            // Then
            assertEquals("model is marked non-null but is null", e.getMessage());
        }
    }

    @DisplayName("Test exception when model is empty with the required and optional attributes")
    @Test
    void testRaceCarEmptyModelRequiredAndOptionalAttributes() {
        double horsePower = 500;
        String carName = "Porsche 911 GT3";

        // When
        try {
            RaceCar raceCar = new RaceCar("", horsePower, carName);
        } catch (IllegalArgumentException e) {
            // Then
            assertEquals("Model cannot be empty", e.getMessage());
        }
    }

    @DisplayName("Test if the RaceCar class has a constructor with the required and repeatable attributes")
    @Test
    void testRaceCarRequiredAndRepeatableAttributes() {
        // Given
        String model = "911 GT3";
        double horsePower = 500;
        Driver driver1 = new Driver("Michael", 30, "Schumacher");
        Driver driver2 = new Driver("Sebastian", 33, "Vettel");

        // When
        RaceCar raceCar = new RaceCar(model, horsePower, List.of(driver1, driver2));

        // Then
        assertEquals(model, raceCar.getModel());
        assertEquals(horsePower, raceCar.getHorsePower());
        assertEquals(2, raceCar.getDrivers().size());
    }

    @DisplayName("Test exception when the horse power is negative with the required and repeatable attributes")
    @Test
    void testRaceCarNegativeHorsePowerRequiredAndRepeatableAttributes() {
        // Given
        String model = "911 GT3";
        double horsePower = -500;
        Driver driver1 = new Driver("Michael", 30, "Schumacher");
        Driver driver2 = new Driver("Sebastian", 33, "Vettel");

        // When
        try {
            RaceCar raceCar = new RaceCar(model, horsePower, List.of(driver1, driver2));
        } catch (IllegalArgumentException e) {
            // Then
            assertEquals("Horse power cannot be negative", e.getMessage());
        }
    }

    @DisplayName("Test exception when the horse power is greater than 1000 with the required and repeatable attributes")
    @Test
    void testRaceCarHorsePowerGreaterThan1000RequiredAndRepeatableAttributes() {
        // Given
        String model = "911 GT3";
        double horsePower = 1500;
        Driver driver1 = new Driver("Michael", 30, "Schumacher");
        Driver driver2 = new Driver("Sebastian", 33, "Vettel");

        // When
        try {
            RaceCar raceCar = new RaceCar(model, horsePower, List.of(driver1, driver2));
        } catch (IllegalArgumentException e) {
            // Then
            assertEquals("Horse power cannot be greater than 1000", e.getMessage());
        }
    }

    @DisplayName("Test exception when model is null with the required and repeatable attributes")
    @Test
    void testRaceCarNullModelRequiredAndRepeatableAttributes() {
        double horsePower = 500;
        Driver driver1 = new Driver("Michael", 30, "Schumacher");
        Driver driver2 = new Driver("Sebastian", 33, "Vettel");

        // When
        try {
            RaceCar raceCar = new RaceCar(null, horsePower, List.of(driver1, driver2));
        } catch (NullPointerException e) {
            // Then
            assertEquals("model is marked non-null but is null", e.getMessage());
        }
    }

    @DisplayName("Test exception when model is empty with the required and repeatable attributes")
    @Test
    void testRaceCarEmptyModelRequiredAndRepeatableAttributes() {
        double horsePower = 500;
        Driver driver1 = new Driver("Michael", 30, "Schumacher");
        Driver driver2 = new Driver("Sebastian", 33, "Vettel");

        // When
        try {
            RaceCar raceCar = new RaceCar("", horsePower, List.of(driver1, driver2));
        } catch (IllegalArgumentException e) {
            // Then
            assertEquals("Model cannot be empty", e.getMessage());
        }
    }

    @DisplayName("Test if the RaceCar class has a constructor with the required, optional and repeatable attributes")
    @Test
    void testRaceCarRequiredOptionalAndRepeatableAttributes() {
        // Given
        String model = "911 GT3";
        double horsePower = 500;
        String carName = "PCH2024";
        Driver driver1 = new Driver("Michael", 30, "Schumacher");
        Driver driver2 = new Driver("Sebastian", 33, "Vettel");

        // When
        RaceCar raceCar = new RaceCar(model, horsePower, carName, List.of(driver1, driver2));

        // Then
        assertEquals(model, raceCar.getModel());
        assertEquals(horsePower, raceCar.getHorsePower());
        assertEquals(carName, raceCar.getCarName());
        assertEquals(2, raceCar.getDrivers().size());
    }

    @DisplayName("Test exception when the horse power is negative with the required, optional and repeatable attributes")
    @Test
    void testRaceCarNegativeHorsePowerRequiredOptionalAndRepeatableAttributes() {
        // Given
        String model = "911 GT3";
        double horsePower = -500;
        String carName = "PCH2024";
        Driver driver1 = new Driver("Michael", 30, "Schumacher");
        Driver driver2 = new Driver("Sebastian", 33, "Vettel");

        // When
        try {
            RaceCar raceCar = new RaceCar(model, horsePower, carName, List.of(driver1, driver2));
        } catch (IllegalArgumentException e) {
            // Then
            assertEquals("Horse power cannot be negative", e.getMessage());
        }
    }

    @DisplayName("Test exception when the horse power is greater than 1000 with the required, optional and repeatable attributes")
    @Test
    void testRaceCarHorsePowerGreaterThan1000RequiredOptionalAndRepeatableAttributes() {
        // Given
        String model = "911 GT3";
        double horsePower = 1500;
        String carName = "PCH2024";
        Driver driver1 = new Driver("Michael", 30, "Schumacher");
        Driver driver2 = new Driver("Sebastian", 33, "Vettel");

        // When
        try {
            RaceCar raceCar = new RaceCar(model, horsePower, carName, List.of(driver1, driver2));
        } catch (IllegalArgumentException e) {
            // Then
            assertEquals("Horse power cannot be greater than 1000", e.getMessage());
        }
    }

    @DisplayName("Test exception when model is null with the required, optional and repeatable attributes")
    @Test
    void testRaceCarNullModelRequiredOptionalAndRepeatableAttributes() {
        double horsePower = 500;
        String carName = "PCH2024";
        Driver driver1 = new Driver("Michael", 30, "Schumacher");
        Driver driver2 = new Driver("Sebastian", 33, "Vettel");

        // When
        try {
            RaceCar raceCar = new RaceCar(null, horsePower, carName, List.of(driver1, driver2));
        } catch (NullPointerException e) {
            // Then
            assertEquals("model is marked non-null but is null", e.getMessage());
        }
    }

    @DisplayName("Test exception when model is empty with the required, optional and repeatable attributes")
    @Test
    void testRaceCarEmptyModelRequiredOptionalAndRepeatableAttributes() {
        double horsePower = 500;
        String carName = "PCH2024";
        Driver driver1 = new Driver("Michael", 30, "Schumacher");
        Driver driver2 = new Driver("Sebastian", 33, "Vettel");

        // When
        try {
            RaceCar raceCar = new RaceCar("", horsePower, carName, List.of(driver1, driver2));
        } catch (IllegalArgumentException e) {
            // Then
            assertEquals("Model cannot be empty", e.getMessage());
        }
    }

    // Method tests

    @DisplayName("Test if the RaceCar class has a static method to get the raceCar extension")
    @Test
    void testRaceCarExtension() {
        // Given
        String model = "911 GT3";
        double horsePower = 500;

        // When
        RaceCar raceCar = new RaceCar(model, horsePower);

        // Then
        assertEquals(1, RaceCar.getExtension().size());
    }

    @DisplayName("Test if the RaceCar class has a static attribute manufacturer")
    @Test
    void testRaceCarManufacturer() {
        // Given
        String model = "911 GT3";
        double horsePower = 500;

        // When
        RaceCar raceCar = new RaceCar(model, horsePower);

        // Then
        assertEquals("Porsche", RaceCar.getManufacturer());
    }

    @DisplayName("Test if the RaceCar class has a method to set the horse power")
    @Test
    void testRaceCarSetHorsePower() {
        // Given
        String model = "911 GT3";
        double horsePower = 500;
        double newHorsePower = 600;

        // When
        RaceCar raceCar = new RaceCar(model, horsePower);

        // Then
        assertDoesNotThrow(() -> raceCar.setHorsePower(newHorsePower));
    }

    @DisplayName("Test if the RaceCar class has a method to set the horse power with a negative value")
    @Test
    void testRaceCarSetHorsePowerNegative() {
        // Given
        String model = "911 GT3";
        double horsePower = 500;
        double newHorsePower = -600;

        // When
        RaceCar raceCar = new RaceCar(model, horsePower);

        // Then
        try {
            raceCar.setHorsePower(newHorsePower);
        } catch (IllegalArgumentException e) {
            assertEquals("Horse power cannot be negative", e.getMessage());
        }
    }

    @DisplayName("Test if the RaceCar class has a method to set the horse power with a value greater than 1000")
    @Test
    void testRaceCarSetHorsePowerGreaterThan1000() {
        // Given
        String model = "911 GT3";
        double horsePower = 500;
        double newHorsePower = 1500;

        // When
        RaceCar raceCar = new RaceCar(model, horsePower);

        // Then
        try {
            raceCar.setHorsePower(newHorsePower);
        } catch (IllegalArgumentException e) {
            assertEquals("Horse power cannot be greater than 1000", e.getMessage());
        }
    }

    @DisplayName("Test if the RaceCar class has a method to calculate the kilowatts")
    @Test
    void calculateKilowattsDerivedAttribute() {
        RaceCar car = new RaceCar("911", 450);
        double kilowatts = car.calculateKilowatts();
        assertEquals(450 * 0.735499, kilowatts, 0.001);
    }

    // RaceCar carName tests

    @DisplayName("Test if car name can be null")
    @Test
    void testRaceCarNullCarName() {
        // Given
        String model = "911 GT3";
        double horsePower = 500;
        String carName = null;

        // When
        RaceCar raceCar = new RaceCar(model, horsePower, carName);

        // Then
        assertEquals(carName, raceCar.getCarName());
    }

    @DisplayName("Test if car name can be an empty string")
    @Test
    void testRaceCarEmptyCarName() {
        // Given
        String model = "911 GT3";
        double horsePower = 500;
        String carName = "";

        // When
        RaceCar raceCar = new RaceCar(model, horsePower, carName);

        // Then
        assertEquals(carName, raceCar.getCarName());
    }

    @DisplayName("Test if you can set the car name to null")
    @Test
    void testRaceCarSetNullCarName() {
        // Given
        String model = "911 GT3";
        double horsePower = 500;
        String carName = "Porsche 911 GT3";

        // When
        RaceCar raceCar = new RaceCar(model, horsePower, carName);

        // Then
        assertDoesNotThrow(() -> {
            raceCar.setCarName(null);
        });
    }

    @DisplayName("Test if you can set the car name to an empty string")
    @Test
    void testRaceCarSetEmptyCarName() {
        // Given
        String model = "911 GT3";
        double horsePower = 500;
        String carName = "Porsche 911 GT3";

        // When
        RaceCar raceCar = new RaceCar(model, horsePower, carName);

        // Then
        assertDoesNotThrow(() -> raceCar.setCarName(""));
    }
}
