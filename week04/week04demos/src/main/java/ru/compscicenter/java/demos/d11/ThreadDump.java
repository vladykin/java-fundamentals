package ru.compscicenter.java.demos.d11;

import java.math.BigInteger;

public class ThreadDump {

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            factorial(10000);
            Thread.sleep(10);
        }
    }

    private static BigInteger factorial(int n) {
        return n <= 1
                ? BigInteger.ONE
                : factorial(n - 1).multiply(BigInteger.valueOf(n));
    }
}

// jps, jstack