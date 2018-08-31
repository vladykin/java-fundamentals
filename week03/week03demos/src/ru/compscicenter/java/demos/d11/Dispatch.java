package ru.compscicenter.java.demos.d11;

public class Dispatch {

    public static void main(String[] args) {
        A a = new B();
        a.foo();

        // static, null
    }
}


class A {
    void foo() {
        System.out.println("A");
    }
}


class B extends A {
    void foo() {
        System.out.println("B");
    }
}
