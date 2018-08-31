package ru.csc.java.demos.d08;

import java.io.Serializable;

public class Demo implements Serializable {

    public int a;
    public int b;

    public Demo() {
        System.out.println("Demo constructor");
    }
}
