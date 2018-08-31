package ru.csc.java.lowlevel;

import java.util.Arrays;
import java.util.function.Consumer;

public class Outer {

    public static void main(String[] args) {
        System.out.println("Loop 1");
        Arrays.stream(args).forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });


        System.out.println("Loop 2");
        Arrays.stream(args).forEach(s -> System.out.println(s));
    }


    class Inner {

    }
}
