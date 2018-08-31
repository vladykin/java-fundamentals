package ru.compscicenter.java.demos.d10;

public class OutOfMemory {

    public static void main(String[] args) {
        //byte[] ints = new byte[Integer.MAX_VALUE-2];
    }
}

// -Xmx6g
// , Runtime.getRuntime().maxMemory()
// -XX:+HeapDumpOnOutOfMemoryError, jhat, VisualVM
