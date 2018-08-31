package ru.csc.java.demos.d05;

import com.google.common.base.Stopwatch;

import java.util.stream.LongStream;

public class ParallelStream {

    public static void main(String[] args) {
        Stopwatch stopwatch1 = Stopwatch.createStarted();
        long sum1 = LongStream.range(0, 10_000_000_000L).parallel().sum();
        System.out.printf("Parallel: sum = %d, elapsed time = %s\n", sum1, stopwatch1.toString());

        Stopwatch stopwatch2 = Stopwatch.createStarted();
        long sum2 = LongStream.range(0, 10_000_000_000L).sum();
        System.out.printf("Sequential: sum = %d, elapsed time = %s\n", sum2, stopwatch2.toString());
    }
}
