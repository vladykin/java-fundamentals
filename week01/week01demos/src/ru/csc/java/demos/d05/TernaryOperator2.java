package ru.csc.java.demos.d05;

public class TernaryOperator2 {
    public static void main(String[] args) {
        boolean flag = true;

        Integer value = null;

        Integer n;
        if (flag) {
            n = value;
        } else {
            n = 1;
        }
        System.err.println(n);


        n = flag ? value : 1;
        System.err.println(n);
    }
}
