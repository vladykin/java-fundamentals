package ru.csc.java.networking.uri;

import java.io.InputStream;
import java.net.URL;

public class UrlDemo {

    public static void main(String[] args) throws Exception {
        URL url = UrlDemo.class.getResource("UrlDemo.class");

        System.out.println(url);
        try (InputStream inputStream = url.openStream()) {
            byte buffer[] = new byte[128];
            int bytesRead = inputStream.read(buffer);
            for (int i = 0; i < bytesRead; ++i) {
                if (i % 32 == 0) {
                    System.out.println();
                }
                System.out.printf("%02X ", buffer[i]);
            }
        }

        // URL.equals
    }
}
