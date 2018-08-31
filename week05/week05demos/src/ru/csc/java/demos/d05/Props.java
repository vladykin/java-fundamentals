package ru.csc.java.demos.d05;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Props {

    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        try (InputStream is = Props.class.getResourceAsStream("my.properties")) {
            properties.load(is);
        }

        System.out.println(properties);

        //System.out.println(System.getProperties());
    }
}
