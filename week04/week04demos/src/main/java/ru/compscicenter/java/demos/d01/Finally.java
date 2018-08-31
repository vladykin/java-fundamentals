package ru.compscicenter.java.demos.d01;

public class Finally {

    public static void main(String[] args) {
        System.out.println(doSomething());
    }

    private static int doSomething() {
        try {
            return 1;
        } finally {
            return 2;
        }
    }
}
