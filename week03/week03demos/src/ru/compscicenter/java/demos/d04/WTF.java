package ru.compscicenter.java.demos.d04;

public class WTF {

    public static int max3(int[] numbers)[]{
        int max = Integer.MIN_VALUE;
        for (int n : numbers) {
            if (max < n) {
                max = n;
            }
        }
        return numbers;
    }
}
