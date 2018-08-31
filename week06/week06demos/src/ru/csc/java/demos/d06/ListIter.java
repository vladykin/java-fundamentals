package ru.csc.java.demos.d06;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class ListIter {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c", "d");

        ListIterator<String> iterator = list.listIterator();
        String next = iterator.next();
        String previous = iterator.previous();

        System.out.println(next + ", " + previous);
    }
}
