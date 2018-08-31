package ru.csc.java.demos.d01;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LoremIpsum {

    public static Stream<String> lines() {
        return getBufferedReader().lines();
    }

    public static Stream<String> tokens() {
        return new Scanner(getBufferedReader()).useDelimiter("[\\s\\.,;!?]+").tokens();
    }

    public static IntStream chars() {
        return getBufferedReader().lines().flatMapToInt(String::chars);
    }

    private static BufferedReader getBufferedReader() {
        return new BufferedReader(new InputStreamReader(getInputStream(), StandardCharsets.UTF_8));
    }

    private static InputStream getInputStream() {
        return LoremIpsum.class.getResourceAsStream("/lorem_ipsum.txt");
    }
}
