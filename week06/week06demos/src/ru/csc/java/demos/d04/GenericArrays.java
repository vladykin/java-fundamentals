package ru.csc.java.demos.d04;

import java.util.ArrayList;
import java.util.List;

public class GenericArrays {

    public static void main(String[] args) {
        List<String>[] arrayOfLists = new ArrayList[10];

        Object[] array = new Number[0];
        array[0] = new Integer(1);

        //List<Object> list = new ArrayList<String>();

        // array reification

        // Collection, ?, raw type
    }
}
