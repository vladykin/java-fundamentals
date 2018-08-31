package ru.csc.java.demos.d03;

public class StringEquality {

    public static void main(String[] args) {
        String s1 = "foobar";
        String s2 = "foobar";
        System.out.println("s1 == s2: " + (s1 == s2));
        System.out.println("s1.equals(s2): " + s1.equals(s2));
        System.out.println();

        String foo = "foo";//, bar = "bar";
        String s3 = foo + "bar";
        System.out.println("s1 == s3: " + (s1 == s3));
        System.out.println("s1.equals(s3): " + s1.equals(s3));
        System.out.println();

        String s4 = "foo" + "bar";
        System.out.println("s1 == s4: " + (s1 == s4));
        System.out.println("s1.equals(s4): " + s1.equals(s4));
        System.out.println();

        String s5 = s3.intern();
        System.out.println("s1 == s5: " + (s1 == s5));
        System.out.println("s1.equals(s5): " + s1.equals(s5));
    }
}
