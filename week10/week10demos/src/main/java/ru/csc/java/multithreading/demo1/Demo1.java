package ru.csc.java.multithreading.demo1;

public class Demo1 {

    public static void main(String[] args) {
        HelloRunnable helloRunnable = new HelloRunnable();
        for (int i = 0; i < 10; ++i) {
            new Thread(helloRunnable).start();
        }

        System.out.println("Hello from main thread");
    }

    private static class HelloRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("Hello from " + Thread.currentThread().getName());
        }
    }


//    private static class HelloThread extends Thread {
//
//        @Override
//        public void run() {
//            System.out.println("Hello from " + getName());
//        }
//    }
}
