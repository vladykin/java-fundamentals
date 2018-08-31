package ru.csc.java.multithreading2.demo1;

import java.util.concurrent.atomic.AtomicLong;

public class Account {

    private final AtomicLong balance;

    public Account() {
        this(0L);
    }

    public Account(long balance) {
        this.balance = new AtomicLong(balance);
    }

    public long getBalance() {
        return balance.get();
    }

    public void deposit(long amount) {
        checkAmountNonNegative(amount);
        balance.addAndGet(amount);
    }

    public void withdraw(long amount) {
        checkAmountNonNegative(amount);
        balance.updateAndGet(currentValue -> {
            if (currentValue < amount) {
                throw new IllegalArgumentException("not enough money");
            }
            return currentValue - amount;
        });
    }

    private static void checkAmountNonNegative(long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("negative amount");
        }
    }
}
