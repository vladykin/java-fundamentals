package ru.csc.java.multithreading.demo5;

public class WaitNotify {

    public static void main(String[] args) throws Exception {
        Account account = new Account(0);

        new Thread(() -> {
            for (int i = 0; i < 60000000; ++i) {
                account.deposit(1);
            }
        }).start();

        account.waitAndWithdraw(50000000);

        System.out.println("waitAndWithdraw finished, end balance = " + account.getBalance());
    }
}
