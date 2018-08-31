package ru.csc.java.multithreading2.demo6;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ParallelInExecutorService {

    public static void main(String[] args) throws Exception {
        int[] array = Commons.prepareArray();

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Instant startTime = Instant.now();

        Future<Double> future1 = executor.submit(new PartialCalc(array, 0, array.length / 2));
        Future<Double> future2 = executor.submit(new PartialCalc(array, array.length / 2, array.length));

        double sum = future1.get() + future2.get();

        Instant endTime = Instant.now();

        System.out.println("sum = " + sum);
        System.out.println("time = " + Duration.between(startTime, endTime));

        executor.shutdown();
    }


    private static class PartialCalc implements Callable<Double> {

        private final int[] array;
        private final int start;
        private final int end;

        private PartialCalc(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        public Double call() throws Exception {
            return Commons.calculate(array, start, end);
        }
    }

}
