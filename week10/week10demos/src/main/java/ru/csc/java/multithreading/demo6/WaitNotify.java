package ru.csc.java.multithreading.demo6;

import java.util.ArrayList;
import java.util.List;

public class WaitNotify {


    private static final int WORKER_COUNT = 10;
    private static int nextWorker = (int) (Math.random() * WORKER_COUNT);

    private static final Object LOCK = new Object();


    public static void main(String[] args) throws Exception {

        List<Thread> threads = new ArrayList<>(WORKER_COUNT);
        for (int i = 0; i < WORKER_COUNT; ++i) {
            Thread thread = new Thread(new Worker(i));
            threads.add(thread);
            thread.start();
        }

        Thread.sleep(10000L);

        for (Thread thread : threads) {
            thread.interrupt();
            thread.join();
        }
    }


    private static class Worker implements Runnable {

        private final int workerId;

        private Worker(int workerId) {
            this.workerId = workerId;
        }

        @Override
        public void run() {
            try {
                for (;;) {
                    synchronized (LOCK) {
                        while (nextWorker != workerId) {
                            LOCK.wait();
                        }
                        System.out.println("Worker " + workerId + " activated");

                        nextWorker = (nextWorker + 1) % WORKER_COUNT;
                        LOCK.notifyAll();
                    }

                    Thread.sleep(1000L);
                }
            } catch (InterruptedException e) {
                System.out.println("Worker " + workerId + " interrupted");
            }
        }
    }
}
