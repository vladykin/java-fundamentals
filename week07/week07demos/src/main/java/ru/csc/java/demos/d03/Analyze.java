package ru.csc.java.demos.d03;

import ru.csc.java.demos.d01.LoremIpsum;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Analyze {

    public static void main(String[] args) {
//        try (Stream<String> tokenStream = LoremIpsum.tokens()) {
//            Map<Integer, Long> lengthToCount = tokenStream
//                    .filter(s -> s.length() > 2)
//                    .collect(groupingBy(String::length, counting()));
//            System.out.println(lengthToCount);
//        }

//        try (Stream<String> tokenStream = LoremIpsum.tokens()) {
//            Map<Integer, Set<String>> lengthToList = tokenStream
//                    .map(String::toLowerCase)
//                    .collect(groupingBy(String::length, toSet()));
//            System.out.println(lengthToList);
//        }
//
//        try (Stream<String> tokenStream = LoremIpsum.tokens()) {
//            Map<Integer, Set<String>> lengthToSet = tokenStream
//                    .collect(groupingBy(String::length, toSet()));
//            System.out.println(lengthToSet);
//        }
//
        try (Stream<String> tokenStream = LoremIpsum.tokens()) {
            Map<String, Long> wordToCount = tokenStream
                    .map(Analyze::canonicalName)
                    .collect(groupingBy(Function.identity(), counting()));
            System.out.println(wordToCount);
        }
    }

    private static String canonicalName(String token) {
        switch (token) {
            case "Дима":
            case "дима":
                return "Дима";
            default:
                return token.toLowerCase();
        }
    }
}
