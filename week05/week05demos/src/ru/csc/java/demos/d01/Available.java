package ru.csc.java.demos.d01;

import java.io.IOException;

public class Available {

    public static void main(String[] args) throws IOException {
        System.out.println(System.in.available());
        for (int read = System.in.read(); read >= 0; read = System.in.read()) {
            System.out.printf("read() returned: %02x%n", read);
        }

        // %n vs \n vs \r\n
    }
}
