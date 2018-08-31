package ru.csc.java.demos.d01;

import java.util.*;

public class Immutables {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3);

        List<Object> unmodifiableList = Collections.unmodifiableList(new ArrayList<>());

        Set<String> foo = Set.of("foo", "bar");

        Map<String, Integer> k1 = Map.of(
                "k1", 1, "k2", 2);
    }
}
