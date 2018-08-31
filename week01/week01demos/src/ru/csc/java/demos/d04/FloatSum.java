package ru.csc.java.demos.d04;

import java.util.Arrays;

public class FloatSum {

    public static void main(String[] args) {
        double[] seq = new double[] {
                1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1,
                16_000_000_000_000_000.0,
                };

        double sum1 = 0;
        for (double num : seq) {
            sum1 += num;
        }
        System.out.printf("sum1 = %f%n", sum1);

        double sum2 = 0;
        for (int i = seq.length - 1; 0 <= i; i--) {
            sum2 += seq[i];
        }
        System.out.printf("sum2 = %f%n", sum2);

        double sum3 = Arrays.stream(seq).sum();
        System.out.printf("sum3 = %f%n", sum3);


        System.out.println(16_000_000_000_000_001.0 - 16_000_000_000_000_000.0);

        System.out.println(Double.toHexString(16_000_000_000_000_008.0));
        System.out.println(Double.toHexString(16_000_000_000_000_007.0));
    }
}
