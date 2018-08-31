package ru.csc.java.demos.d02;

public class Surrogates {

    public static void main(String[] args) {
        String text = "\uD83D\uDE04\uD83D\uDE04\uD83D\uDE04";

        System.out.println("Text: " + text);
        System.out.println("Length: " + text.length());
        for (int i = 0; i < text.length(); i++) {
            System.out.println("charAt(" + i + "): " + text.charAt(i));
        }

        System.out.println("isSurrogatePair(charAt(0), charAt(1)): "
                + Character.isSurrogatePair(text.charAt(0), text.charAt(1)));

        System.out.println("Code points: " + text.codePointCount(0, text.length()));

        int codePoint = text.codePointAt(0);

        for (int offset = 0; offset < text.length();
                offset = text.offsetByCodePoints(offset, 1)) {
            System.out.println("codePointAt(" + offset + "): " + text.codePointAt(offset));
        }

        System.out.println("lastIndexOf(" + codePoint + "): " + text.lastIndexOf(codePoint));


        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.appendCodePoint(codePoint).append(123).appendCodePoint(codePoint);
        System.out.println("StringBuilder: " + stringBuilder);
    }
}
