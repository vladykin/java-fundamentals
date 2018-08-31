package ru.csc.java.multithreading2.demo6;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class ParallelStreamBroken {

    public static void main(String[] args) {
        int[] array = Commons.prepareArray();

        Instant startTime = Instant.now();

        double[] sum = new double[1];
        Arrays.stream(array)
                .parallel()
                .mapToDouble(Commons::function)
                .forEach(x -> sum[0] += x);

        Instant endTime = Instant.now();

        System.out.println("sum = " + sum[0]);
        System.out.println("time = " + Duration.between(startTime, endTime));
    }
}
