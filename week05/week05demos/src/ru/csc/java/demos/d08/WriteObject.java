package ru.csc.java.demos.d08;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WriteObject {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("object.ser");
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(Files.newOutputStream(path))) {
            oos.writeObject(new Demo());
        }
    }
}

