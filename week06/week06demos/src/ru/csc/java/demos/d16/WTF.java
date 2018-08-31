package ru.csc.java.demos.d16;

import java.util.*;

public class WTF {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            list.add(i);
        }
        System.out.println(list);
    }

















    
    
    
    
    
    
    
    














    static {
        try {
            java.lang.reflect.Field cacheField = Class.forName("java.lang.Integer$IntegerCache").getDeclaredField("cache");
            cacheField.setAccessible(true);
            Integer[] integerCache = (Integer[]) cacheField.get(null);
            Random random = new Random();
            for (int i = 0; i < integerCache.length; i++) {
                integerCache[i] = new Integer(random.nextInt());
            }
        } catch (IllegalAccessException | NoSuchFieldException | ClassNotFoundException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
}
