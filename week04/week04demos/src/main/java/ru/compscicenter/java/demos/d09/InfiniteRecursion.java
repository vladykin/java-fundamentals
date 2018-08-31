package ru.compscicenter.java.demos.d09;

public class InfiniteRecursion {

    private static int levels;

    public static void main(String[] args) {
        try {
            recursiveCall();
        } catch (StackOverflowError e) {
            System.err.printf("Stack trace size: %d%n", e.getStackTrace().length);
            System.err.printf("Actual levels: %d%n", levels);
        }
    }

    private static void recursiveCall() {
        levels++;
        recursiveCall();
    }

    // -Xss8m
}
