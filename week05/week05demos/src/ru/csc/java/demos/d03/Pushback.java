package ru.csc.java.demos.d03;

import java.io.IOException;
import java.io.PushbackInputStream;

public class Pushback {

    public static void main(String[] args) throws IOException {
        PushbackInputStream pushbackInputStream = new PushbackInputStream(System.in, 10);
        pushbackInputStream.unread(new byte[] {1, 2, 3, 4, 5, 6, 7});

        int read;
        while ((read = pushbackInputStream.read()) >= 0) {
            System.out.printf("read() returned: %02x%n", read);
        }
    }
}
