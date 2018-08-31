package ru.compscicenter.java.demos.d07;

public class Outer2 {

    private static int x;

    private static class Inner {
        private static int x;

        public static int getX() {
            return Outer2.x;
        }
    }
}
