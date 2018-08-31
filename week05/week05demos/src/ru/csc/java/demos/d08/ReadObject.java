package ru.csc.java.demos.d08;

import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadObject {

    public static void main(String[] args) throws Exception {
        Path path = Paths.get("object.ser");
        try (ObjectInputStream ois =
                     new ObjectInputStream(Files.newInputStream(path))) {
            Demo demo = (Demo) ois.readObject();

            System.out.printf("Successfully read object: a=%d, b=%d%n", demo.a, demo.b);
        }
    }
}
