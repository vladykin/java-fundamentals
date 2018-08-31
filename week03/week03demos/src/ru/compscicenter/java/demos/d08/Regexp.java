package ru.compscicenter.java.demos.d08;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Regexp {

    private static final Pattern PATTERN = Pattern.compile("([ ,\\.!?]+?)");

    public static void main(String[] args) {
        boolean result = areAnagrams("фыва", "фыва");
        System.out.println(result);
    }

    public static boolean areAnagrams(String a, String b) {
        a = PATTERN.matcher(a).replaceAll("").toLowerCase();
        b = PATTERN.matcher(b).replaceAll("").toLowerCase();
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        Arrays.sort(charsA);
        Arrays.sort(charsB);
        return Arrays.equals(charsA, charsB);
    }

}
