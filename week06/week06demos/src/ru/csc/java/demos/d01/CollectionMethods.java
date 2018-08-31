package ru.csc.java.demos.d01;

import java.util.Collection;

public class CollectionMethods {

    public static void main(String[] args) {
        Collection<String> c = null;
        c.removeIf(s -> s.length() > 10);

        // java.util.AbstractCollection
        // java.lang.UnsupportedOperationException
    }
}
