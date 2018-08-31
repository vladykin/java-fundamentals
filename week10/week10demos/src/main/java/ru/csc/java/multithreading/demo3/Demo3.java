package ru.csc.java.multithreading.demo3;

public class Demo3 {

    public static void main(String[] args) throws Exception {
        Account account = new Account(100000);
        System.out.println("Begin balance = " + account.getBalance());

        Thread withdrawThread = new Thread(() -> {
            for (int i = 0; i < 20000; ++i) {
                account.withdraw(1);
            }
        });
        Thread depositThread = new Thread(() -> {
            for (int i = 0; i < 20000; ++i) {
                account.deposit(1);
            }
        });

        withdrawThread.start();
        depositThread.start();

        withdrawThread.join();
        depositThread.join();

        System.out.println("End balance = " + account.getBalance());
    }
}
