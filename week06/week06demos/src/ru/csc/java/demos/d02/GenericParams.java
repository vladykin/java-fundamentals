package ru.csc.java.demos.d02;

import java.util.ArrayList;
import java.util.Collection;

public class GenericParams {

    public static void main(String[] args) {
        Collection<?> c1 = null;
        Collection<Number> c2 = new ArrayList<>();
        Collection c3 = new ArrayList();

        c1 = c2;
        c1 = c3;

        c2 = (Collection) c1;
        c2 = c3;

        c3 = c1;
        c3 = c2;
    }
}
