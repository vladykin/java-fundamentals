package ru.compscicenter.java.demos.d10;

public class DefaultMethodConflict {

    interface A {
        default void foo() {
            System.out.println("A::foo()");
        }
    }
    interface B {
        default void foo() {
            System.out.println("B::foo()");
        }
    }

//    class C implements A, B {
//
//        @Override
//        public void foo() {
//
//        }
//    }
}
