package ru.compscicenter.java.demos.d03;

public class Quiz {

    public static void main(String[] args) {
        try {
            Object nullRef = null;
            System.out.print(nullRef.toString());
        } catch (RuntimeException e) {
            System.out.print("1");
        } catch (Exception e) {
            System.out.print("2");
        } finally {
            System.out.print("3");
        }
    }
}
