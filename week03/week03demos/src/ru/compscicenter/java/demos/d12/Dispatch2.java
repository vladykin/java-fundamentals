package ru.compscicenter.java.demos.d12;

public class Dispatch2 {

    public static void main(String[] args) {
        method(new A());
        method(new B());

        A a = new B();
        method(a);
    }

    private static void method(A a) {
        System.out.println("A");
    }

    private static void method(B b) {
        System.out.println("B");
    }
}


class A {}

class B extends A {}
