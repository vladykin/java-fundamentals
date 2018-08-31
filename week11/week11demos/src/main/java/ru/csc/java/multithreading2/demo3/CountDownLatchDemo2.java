package ru.csc.java.multithreading2.demo3;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo2 {

    public static void main(String[] args) {
        int n = 10;

        Object[] monitors = new Object[n];
        Arrays.setAll(monitors, i -> new Object());

        CountDownLatch countDownLatch = new CountDownLatch(n);

        for (int i = 0; i < n; i++) {
            int j = i;
            new Thread(() -> {
                synchronized (monitors[j]) {

                    countDownLatch.countDown();
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        System.out.println("countDownLatch.await() interrupted");;
                        return;
                    }

                    synchronized (monitors[(j + 1) % n]) {

                    }
                }
            }).start();
        }
    }
}
