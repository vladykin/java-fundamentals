package ru.compscicenter.java.demos.d02;

public class TryWithEffectivelyFinal {

    public static void main(String[] args) {
        try (System.out) {
            System.out.println("Hello world");
        }
    }
}
