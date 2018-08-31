package ru.csc.java.demos.d05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayAsList {

    public static void main(String[] args) {
        String[] array = {"a", "b", "c"};
        List<String> list = Arrays.asList(array);
        list.set(1, "Z");
        //list.remove(2);

        List<String> list2 = new ArrayList<>(Arrays.asList(array));
        Collections.addAll(list2, array);

        System.out.println(Arrays.toString(array));
    }
}
