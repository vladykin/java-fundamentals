package ru.compscicenter.java.demos.d07;

public class Outer {

    private int x = 10;

    private class Inner {
        private int x;

        int getX() {
            return Outer.this.x;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Outer().new Inner().getX());
    }
}
