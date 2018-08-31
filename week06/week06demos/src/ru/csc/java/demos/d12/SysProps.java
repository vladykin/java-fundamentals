package ru.csc.java.demos.d12;

public class SysProps {

    public static void main(String[] args) {
        System.getProperties().forEach((k, v) -> System.out.printf("%s => %s%n", k, v));

        //String foo = System.getProperty("foo");
        //boolean flag = Boolean.getBoolean("ru.csc.java.flag");
        //Integer number = Integer.getInteger("ru.csc.java.number", 10);
    }
}
