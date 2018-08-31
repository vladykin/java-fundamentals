package ru.csc.java.demos.d06;

import java.util.stream.LongStream;

public class ParallelForEach {

    public static void main(String[] args) {
        //LongStream.range(0, 1000).parallel().forEach(System.out::println);

        long correctSum = LongStream.range(0, 1000).sum();
        System.out.printf("Correct sum = %d%n", correctSum);

        long parallelSum[] = {0};
        LongStream.range(0, 1000)
                .parallel()
                .forEach(i -> parallelSum[0] += i);
        System.out.printf("Parallel sum = %d%n", parallelSum[0]);


        // forEachOrdered
    }
}
