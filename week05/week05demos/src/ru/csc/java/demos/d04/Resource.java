package ru.csc.java.demos.d04;

import java.io.IOException;
import java.io.InputStream;

public class Resource {

    public static void main(String[] args) throws IOException {
        Class<?> resourceClass = Resource.class;
        try (InputStream inputStream = resourceClass.getResourceAsStream("/java/lang/String.class")) {
            int totalBytesRead = 0;
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buf)) > 0) {
                for (int i = 0; i < bytesRead; i++) {
                    System.out.printf(" %02X", buf[i]);
                    totalBytesRead++;
                    if (totalBytesRead % 20 == 0) {
                        System.out.println();
                    }
                }
            }
        }
    }
}
