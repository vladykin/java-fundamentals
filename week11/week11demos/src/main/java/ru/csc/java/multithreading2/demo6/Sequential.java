package ru.csc.java.multithreading2.demo6;

import java.time.Duration;
import java.time.Instant;

public class Sequential {

    public static void main(String[] args) {
        int[] array = Commons.prepareArray();

        Instant startTime = Instant.now();

        double sum = Commons.calculate(array);

        Instant endTime = Instant.now();

        System.out.println("sum = " + sum);
        System.out.println("time = " + Duration.between(startTime, endTime));
    }
}
