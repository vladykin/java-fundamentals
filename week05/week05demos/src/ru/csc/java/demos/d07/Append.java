package ru.csc.java.demos.d07;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class Append {

    public static void main(String[] args) throws IOException {
//        try (OutputStream outputStream =
//                     new FileOutputStream("output.txt", true)) {
//            outputStream.write("foobar\n".getBytes(StandardCharsets.UTF_8));
//        }


        Path path = Paths.get("output.txt");
        try (OutputStream outputStream =
                     Files.newOutputStream(path,
                             StandardOpenOption.CREATE_NEW,
                             StandardOpenOption.APPEND)) {
            outputStream.write("second foobar\n".getBytes(StandardCharsets.UTF_8));
        }
    }
}
