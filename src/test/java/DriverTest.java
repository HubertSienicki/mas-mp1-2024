import org.example.driver.Driver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DriverTest {

    // Only one constructor used
    @DisplayName("Test object instantiation")
    @Test
    void testDriverRequiredAttributes() {
        // Given
        String firstname = "John";
        String lastname = "Doe";
        int age = 30;

        // When
        Driver driver = new Driver(firstname, age, lastname);

        // Then
        assertEquals(firstname, driver.getFirstname());
        assertEquals(lastname, driver.getLastname());
        assertEquals(age, driver.getAge());
    }

    @DisplayName("Test composed attribute")
    @Test
    void testGetFullName() {
        // Given
        String firstname = "John";
        String lastname = "Doe";
        int age = 30;

        // When
        Driver driver = new Driver(firstname, age, lastname);

        // Then
        assertEquals(firstname + " " + lastname, driver.getFullName());
    }

    @DisplayName("Test age setter")
    @Test
    void testSetAge() {
        // Given
        String firstname = "John";
        String lastname = "Doe";
        int age = 30;

        // When
        Driver driver = new Driver(firstname, age, lastname);

        // Then
        assertEquals(age, driver.getAge());
    }

    @DisplayName("Test age setter with negative value")
    @Test
    void testSetAgeNegative() {
        // Given
        String firstname = "John";
        String lastname = "Doe";
        int age = -30;

        // When
        Driver driver = new Driver(firstname, 20, lastname);

        // Then
        try {
            driver.setAge(age);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Age cannot be negative or equal to zero", e.getMessage());
        }
    }

    @DisplayName("Test age setter with positive value")
    @Test
    void testSetAgePositive() {
        // Given
        String firstname = "John";
        String lastname = "Doe";
        int age = 30;

        // When
        Driver driver = new Driver(firstname, age, lastname);

        // Then
        assertDoesNotThrow(() -> driver.setAge(age));
        assertEquals(age, driver.getAge());
    }

    @DisplayName("Test age setter with zero value")
    @Test
    void testSetAgeZero() {
        // Given
        String firstname = "John";
        String lastname = "Doe";
        int age = 0;

        // When
        Driver driver = new Driver(firstname,20, lastname);

        // Then
        try {
            driver.setAge(age);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Age cannot be negative or equal to zero", e.getMessage());
        }
    }

    @DisplayName("Test firstname setter")
    @Test
    void testSetFirstname() {
        // Given
        String firstname = "John";
        String lastname = "Doe";
        int age = 30;

        // When
        Driver driver = new Driver(firstname, age, lastname);

        // Then
        assertEquals(firstname, driver.getFirstname());
    }

    @DisplayName("Test firstname setter with null value")
    @Test
    void testSetFirstnameNull() {
        // Given
        String firstname = null;
        String lastname = "Doe";
        int age = 30;

        // When
        try {
            Driver driver = new Driver(firstname, age, lastname);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (NullPointerException e) {
            assertEquals("firstname is marked non-null but is null", e.getMessage());
        }
    }

    @DisplayName("Test firstname setter with empty value")
    @Test
    void testSetFirstnameEmpty() {
        // Given
        String firstname = "";
        String lastname = "Doe";
        int age = 30;

        // When
        try {
            Driver driver = new Driver(firstname, age, lastname);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("First name cannot be empty", e.getMessage());
        }
    }

    @DisplayName("Test lastname setter")
    @Test
    void testSetLastname() {
        // Given
        String firstname = "John";
        String lastname = "Doe";
        int age = 30;

        // When
        Driver driver = new Driver(firstname, age, lastname);

        // Then
        assertEquals(lastname, driver.getLastname());
    }

    @DisplayName("Test lastname setter with empty value")
    @Test
    void testSetLastnameEmpty() {
        // Given
        String firstname = "John";
        String lastname = "";
        int age = 30;

        // When
        try {
            Driver driver = new Driver(firstname, age, lastname);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Last name cannot be empty", e.getMessage());
        }
    }

    @DisplayName("Test lastname setter with null value")
    @Test
    void testSetLastnameNull() {
        // Given
        String firstname = "John";
        String lastname = null;
        int age = 30;

        // When
        try {
            Driver driver = new Driver(firstname, age, lastname);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (NullPointerException e) {
            assertEquals("lastname is marked non-null but is null", e.getMessage());
        }
    }
}
