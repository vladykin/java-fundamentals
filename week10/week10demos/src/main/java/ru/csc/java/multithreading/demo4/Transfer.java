package ru.csc.java.multithreading.demo4;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Transfer {

    private static final int NUMBER_OF_ACCOUNTS = 3;

    public static void main(String[] args) {
        Account[] accounts = new Account[NUMBER_OF_ACCOUNTS];
        Arrays.setAll(accounts, i -> new Account(1_000_000));

        Runnable runnable = new TransferRunnable(accounts);
        for (int i = 0; i < NUMBER_OF_ACCOUNTS; i++) {
            new Thread(runnable).start();
        }
    }

    private static class TransferRunnable implements Runnable {

        private final Account[] accounts;

        public TransferRunnable(Account[] accounts) {
            this.accounts = accounts;
        }

        @Override
        public void run() {
            ThreadLocalRandom random = ThreadLocalRandom.current();
            for (int i = 0; i < 1_000_000; i++) {
                int from = random.nextInt(NUMBER_OF_ACCOUNTS);
                int to = random.nextInt(NUMBER_OF_ACCOUNTS);
                synchronized (accounts[from]) {
                    synchronized (accounts[to]) {
                        accounts[from].withdraw(1);
                        accounts[to].deposit(1);
                    }
                }
            }
        }
    }
}
