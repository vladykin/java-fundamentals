package ru.csc.java.networking.http;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpClientUrlBased {

    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:11111");
        try (InputStream inputStream = url.openStream()) {
            new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                    .lines()
                    .forEach(System.out::println);
        }
    }
}
