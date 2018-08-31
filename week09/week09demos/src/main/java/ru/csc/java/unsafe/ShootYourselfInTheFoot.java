package ru.csc.java.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.OptionalInt;

public class ShootYourselfInTheFoot {

    private static final Unsafe unsafe;
    static {
        try {
            Field theUnsafeField = Class.forName("sun.misc.Unsafe").getDeclaredField("theUnsafe");
            theUnsafeField.setAccessible(true);
            unsafe = (Unsafe) theUnsafeField.get(null);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void main(String[] args) throws Exception {
        dumpObjectMemory(OptionalInt.of(0x11223344));
    }

    private static void dumpObjectMemory(Object obj) {
        for (int i = 0; i < 16; i++) {
            System.out.printf("%02X ", unsafe.getByte(obj, (long) i));
        }
    }
}
