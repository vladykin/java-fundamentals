package ru.compscicenter.java.demos.d05;

public class StrBuilder {

    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder(9);
        System.out.println(sb1);

        StringBuilder sb2 = new StringBuilder('9');
        System.out.println(sb2);

        StringBuilder sb3 = new StringBuilder("9");
        System.out.println(sb3);
    }

    // +StringBuffer
}
