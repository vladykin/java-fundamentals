package ru.csc.java.multithreading.demo2;

public class Demo2 {

    public static void main(String[] args) throws Exception {
        Thread worker = new Thread(() -> {
            long sum = 0;
            for (int i = 0; i < 10000000; ++i) {
                sum += i;
                if (i % 100 == 0 && Thread.currentThread().isInterrupted()) {
                    System.out.println("Loop interrupted at i = " + i);
                    break;
                }
            }
        });
        //worker.setDaemon(true);
        Thread sleeper = new Thread(() -> {
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                System.out.println("Sleep interrupted");
            }
        });
        //sleeper.setDaemon(true);

        System.out.println("Starting threads");
        worker.start();
        sleeper.start();

        System.out.println("Interrupting threads");
        worker.interrupt();
        sleeper.interrupt();

        System.out.println("Joining threads");
        worker.join();
        sleeper.join();

        System.out.println("All done");
    }
}
