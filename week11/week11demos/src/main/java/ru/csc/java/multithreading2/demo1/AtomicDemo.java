package ru.csc.java.multithreading2.demo1;

public class AtomicDemo {

    private static final long BALANCE = 2_000_000;

    public static void main(String[] args) throws Exception {
        Account account = new Account(BALANCE);

        Thread depositThread = new Thread(() -> {
            for (int i = 0; i < BALANCE; ++i) {
                account.deposit(1);
            }
        });
        depositThread.start();

        Thread withdrawThread = new Thread(() -> {
            for (int i = 0; i < BALANCE; ++i) {
                account.withdraw(1);
            }
        });
        withdrawThread.start();

        depositThread.join();
        withdrawThread.join();

        System.out.println(account.getBalance());
    }
}
