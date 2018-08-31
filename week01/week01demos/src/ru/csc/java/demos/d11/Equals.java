package ru.csc.java.demos.d11;

public class Equals {

    public static void main(String[] args) {
        float a = Float.NaN;
        float b = Float.NaN;
        System.out.println(a == b);
//        System.out.println(((Float) a).equals((Float) b));
//        System.out.println(Arrays.equals(new Float[]{a}, new Float[]{b}));
//        System.out.println(Arrays.equals(new float[]{a}, new float[]{b}));
    }
}
