package ru.csc.java.multithreading2.demo7;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {

    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> Math.PI)
                .thenApply(Math::sin)
                .thenAccept(System.out::println);
    }
}
