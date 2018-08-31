package ru.csc.java.demos.d03;

public class GenericVarargs {

    public static void main(String[] args) {
        String[] array = asArray("a", "b");

        // Arrays.asList()
    }

    public static <T> T[] arrayOfTwo(T a, T b) {
        return asArray(a, b);
    }

    //@SafeVarargs
    public static <T> T[] asArray(T... elements) {
        return elements;
    }
}
