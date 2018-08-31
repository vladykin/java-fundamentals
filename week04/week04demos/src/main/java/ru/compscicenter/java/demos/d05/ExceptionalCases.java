package ru.compscicenter.java.demos.d05;

import java.util.Arrays;

public class ExceptionalCases {

    public static void main(String[] args) {
        System.out.println(isPrime(7));
    }

    private static boolean isPrime(int n) {
        int[] divisors = getNonTrivialDivisors(n);
        return divisors.length == 0;
    }

    private static int[] getNonTrivialDivisors(int n) {
        int maxDivisor = n / 2;
        int[] divisors = new int[maxDivisor];
        int count = 0;
        for (int i = 2; i <= maxDivisor; i++) {
            if (n % i == 0) {
                divisors[count] = i;
                count++;
            }
        }
        return Arrays.copyOf(divisors, count);
    }
}
