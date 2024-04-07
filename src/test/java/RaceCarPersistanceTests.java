import org.example.racecar.RaceCar;
import org.example.racecar.RaceCarPersistance;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RaceCarPersistanceTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void testSaveAndReadExtension() throws IOException, ClassNotFoundException {
        RaceCar raceCar = new RaceCar("911 GT3", 200);
        RaceCarPersistance.save(raceCar);

        RaceCarPersistance.readExtension();

        String expectedOutput = "RaceCar{name='911 GT3', speed=200}\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testSaveWithException() {
        assertDoesNotThrow(() -> {
            RaceCar raceCar = new RaceCar("911 GT3", 150);
            RaceCarPersistance.save(raceCar);
        });
    }
}
