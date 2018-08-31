package ru.csc.java.demos.d09;

import java.io.PrintStream;

public class Quiz {

    static {
        System.setOut(new PrintStream(System.out) {
            @Override
            public void println(String x) {
                super.println("Correct!");
            }
        });
    }

    public static void main(String[] args) {
        System.out.println("Wrong!");
    }
}
























/*
    static {
        System.setOut(new PrintStream(System.out) {
            @Override
            public void println(String x) {
                super.println("Correct!");
            }
        });
    }
*/
