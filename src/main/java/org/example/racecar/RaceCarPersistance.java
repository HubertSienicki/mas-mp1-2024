package org.example.racecar;

import java.io.*;

public class RaceCarPersistance {
    public static void save(RaceCar raceCar) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("racecar.dat"))) {
            oos.writeObject(raceCar);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readExtension() throws IOException, ClassNotFoundException {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("racecar.dat"))) {
            RaceCar extension = (RaceCar) ois.readObject();
            System.out.println(extension);
        }
    }
}
