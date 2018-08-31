package ru.csc.java.demos.d06;

public class PrimitiveWrappers {

    public static void main(String[] args) {
        Integer n1 = 1;
        Integer n2 = 1;
        System.out.println("n1 = " + n1 + ", n2 = " + n2);
        System.out.println("n1 == n2: " + (n1 == n2));
        System.out.println("n1.equals(n2): " + n1.equals(n2));
        System.out.println();

        n1 = 100;
        n2 = 100;
        System.out.println("n1 = " + n1 + ", n2 = " + n2);
        System.out.println("n1 == n2: " + (n1 == n2));
        System.out.println("n1.equals(n2): " + n1.equals(n2));
        System.out.println();

        n1 = 200;
        n2 = 200;
        System.out.println("n1 = " + n1 + ", n2 = " + n2);
        System.out.println("n1 == n2: " + (n1 == n2));
        System.out.println("n1.equals(n2): " + n1.equals(n2));
        System.out.println();

        n1 = new Integer(200);
        n2 = new Integer(200);
        System.out.println("n1 = " + n1 + ", n2 = " + n2);
        System.out.println("n1 == n2: " + (n1 == n2));
        System.out.println("n1.equals(n2): " + n1.equals(n2));
        System.out.println();
    }
}
