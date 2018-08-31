package ru.csc.java.demos.d05;

public class TernaryOperator1 {

    public static void main(String[] args) {
        boolean flag = true;
        Number n;
        if (flag) {
            n = new Integer(1);
        } else {
            n = new Double(2.0);
        }
        System.out.println(n.getClass().getName() + ": " + n);

        n = flag ? new Integer(1) : new Double(2.0);
        System.out.println(n.getClass().getName() + ": " + n);


    }
}
