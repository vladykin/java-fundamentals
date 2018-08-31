package ru.csc.java.multithreading2.demo6;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class ParallelStream {

    public static void main(String[] args) {
        int[] array = Commons.prepareArray();


        Instant startTime = Instant.now();

        double sum = Arrays.stream(array)
                .parallel()
                .mapToDouble(Commons::function)
                .sum();

        Instant endTime = Instant.now();

        System.out.println("sum = " + sum);
        System.out.println("time = " + Duration.between(startTime, endTime));
    }
}
