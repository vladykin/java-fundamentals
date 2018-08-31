package ru.csc.java.demos.d08;

import java.util.function.IntPredicate;

public class Oddity {

    public static void main(String[] args) {
        IntPredicate oddityTest = x -> x % 2 == 1;
        doTest(oddityTest);
    }

    private static void doTest(IntPredicate oddityTest) {
        int[] testNumbers = new int[] {-1, 0, 1, 2, 200, 201};
        for (int number : testNumbers) {
            System.out.printf("%d -> %s%n",
                    number,
                    oddityTest.test(number) ? "odd" : "even");
        }
    }
}


// (a / n) + (a % n) == n
