package ru.csc.java.demos.d02;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MarkReset {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        System.out.println(inputStream.getClass().getName());

        if (!inputStream.markSupported()) {
            throw new IllegalStateException("Mark not supported");
        }

        inputStream.mark(1024);

        byte[] buf = new byte[1024];
        int bytesRead = inputStream.read(buf);
        for (int i = 0; i < bytesRead; i++) {
            System.out.printf("read() returned: %02x%n", buf[i]);
        }

        System.out.println("Calling reset()");
        inputStream.reset();

        bytesRead = inputStream.read(buf);
        for (int i = 0; i < bytesRead; i++) {
            System.out.printf("read() returned: %02x%n", buf[i]);
        }
    }
}
