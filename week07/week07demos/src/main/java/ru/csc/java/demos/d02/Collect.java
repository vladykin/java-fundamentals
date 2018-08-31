package ru.csc.java.demos.d02;

import ru.csc.java.demos.d01.LoremIpsum;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collect {

    public static void main(String[] args) {
        try (Stream<String> tokenStream = LoremIpsum.tokens()) {
            Set<String> set = tokenStream.collect(
                    Collectors.toSet());
            System.out.println(set);

            // Collectors.toSet()
            // Collectors.toCollection()
            // Collectors.toMap()

            // tokenStream.forEach(System.out::println)
        }
    }

}
