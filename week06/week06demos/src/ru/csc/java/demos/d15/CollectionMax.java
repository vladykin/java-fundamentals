package ru.csc.java.demos.d15;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class CollectionMax {

    public static void main(String[] args) {
        max(Arrays.asList(args));
    }

    public static <T extends Object & Comparable<? super T>> T max(Collection<? extends T> coll) {
        return Collections.max(coll);
    }
}
