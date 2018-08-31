package ru.csc.java.demos.d09;

import java.util.*;

public class Nulls {

    public static void main(String[] args) {
        checkAllowsNull(new ArrayList<>());
        checkAllowsNull(new LinkedList<>());
        checkAllowsNull(new HashSet<>());
        checkAllowsNull(new TreeSet<>());
        checkAllowsNull(new ArrayDeque<>());
        checkAllowsNull(new PriorityQueue<>());

        // (o1, o2) -> 0
    }

    private static <T> void checkAllowsNull(Collection<T> c) {
        try {
            c.add(null);
            System.out.println(c.getClass().getName() + " allows null");
        } catch (NullPointerException e) {
            System.out.println(c.getClass().getName() + " does NOT allow null");
        }
    }
}
