package ru.csc.java.demos.d08;

import java.math.BigDecimal;
import java.util.PriorityQueue;

public class PriorityQ {

    public static void main(String[] args) {
        PriorityQueue<BigDecimal> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(BigDecimal.ONE);
        priorityQueue.add(BigDecimal.ZERO);
        priorityQueue.add(BigDecimal.TEN);
        priorityQueue.add(BigDecimal.ZERO);
        priorityQueue.add(BigDecimal.valueOf(100));
        priorityQueue.add(BigDecimal.valueOf(-1));
        priorityQueue.add(BigDecimal.valueOf(-10));
        priorityQueue.add(BigDecimal.valueOf(-50));

        System.out.println("forEach:");
        //priorityQueue.forEach(System.out::println);
        priorityQueue.stream().forEachOrdered(System.out::println);

        System.out.println("poll:");
        BigDecimal bd;
        while ((bd = priorityQueue.poll()) != null) {
            System.out.println(bd);
        }
    }
}
