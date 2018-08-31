package ru.csc.java.demos.d11;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Props {

    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        try (InputStream inputStream = Props.class.getResourceAsStream("demo.properties")) {
            properties.load(inputStream);
        }

        System.out.println(properties.getProperty("foo"));
        System.out.println(properties.getProperty("hello"));
        System.out.println(properties.getProperty("multiline"));
        System.out.println(properties.getProperty("baz", "default"));
    }
}
