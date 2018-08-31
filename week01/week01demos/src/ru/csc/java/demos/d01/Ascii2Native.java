package ru.csc.java.demos.d01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ascii2Native {

    private static final int ESCAPE_SEQUENCE_LENGTH = 6;


    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: java " + Ascii2Native.class.getName() + " <source file>");
            System.exit(1);
        }

        ascii2native(Paths.get(args[0]));
    }

    private static void ascii2native(Path path) throws IOException {
        byte[] content = Files.readAllBytes(path);
        int i = 0;
        while (i + ESCAPE_SEQUENCE_LENGTH - 1 < content.length) {
            if (content[i] == '\\' && content[i + 1] == 'u') {
                char decodedChar = decodeChar(content[i + 2], content[i + 3], content[i + 4], content[i + 5]);
                System.out.print(decodedChar);
                i += ESCAPE_SEQUENCE_LENGTH;
            } else {
                System.out.print((char) content[i]);
                i++;
            }
        }
    }

    private static char decodeChar(byte b1, byte b2, byte b3, byte b4) {
        byte d1 = (byte) Character.digit(b1, 16);
        byte d2 = (byte) Character.digit(b2, 16);
        byte d3 = (byte) Character.digit(b3, 16);
        byte d4 = (byte) Character.digit(b4, 16);
        return (char) ((d1 << 12) | (d2 << 8) | (d3 << 4) | d4);
    }
}
