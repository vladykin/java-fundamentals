package ru.csc.java.demos.d06;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RAF {

    public static void main(String[] args) throws IOException {
        try (RandomAccessFile randomAccessFile =
                     new RandomAccessFile("src/ru/csc/java/demos/d06/RAF.java", "rw")) {

            randomAccessFile.seek(14);
            int aByte = randomAccessFile.readUnsignedByte();
            System.out.printf("byte #14 is %02X%n", aByte);

            byte[] buf = new byte[100];
            randomAccessFile.read();
            randomAccessFile.readFully(buf);


            // readFully()
            // write*
        }
    }
}
