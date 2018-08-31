package ru.csc.java.demos.d07;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Quiz {

    public static void main(String[] args) {
        Collection<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            list.add(i);
        }
        for (int i = 0; i < 10; ++i) {
            list.remove(i);
        }
        System.out.println(list);
    }
}
