package ru.csc.java.demos.d13;

import java.util.HashMap;
import java.util.Map;

public class MapMethods {

    public static void main(String[] args) {
        Map<String, Integer> wordFrequencies = new HashMap<>();

        String word = "hello";
        Integer frequency = wordFrequencies.get(word);
        if (frequency == null) {
            frequency = 1;
        } else {
            frequency = frequency + 1;
        }
        wordFrequencies.put(word, frequency);
    }




    // wordFrequencies.getOrDefault(word, 0);
    // wordFrequencies.compute(word, (w, f) -> f == null ? 1 : f + 1);
    // wordFrequencies.merge(word, 1, (a, b) -> a + b);
}
