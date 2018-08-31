package ru.csc.java.demos.d10;

import java.util.*;

public class Quiz {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put("a", "b");
        map.put(new String("a"), "c");

        System.out.println(map.get("a"));
    }

}









































class HashMap<K, V> extends IdentityHashMap<K, V> {

}
