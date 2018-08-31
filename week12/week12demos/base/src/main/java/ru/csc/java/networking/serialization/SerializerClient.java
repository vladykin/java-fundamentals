package ru.csc.java.networking.serialization;

import java.io.ObjectOutputStream;
import java.net.Socket;

public class SerializerClient {

    public static void main(String[] args) throws Exception {
        try (Socket socket = new Socket("localhost", 11111)) {

            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(new SerializablePerson("Ivan", "Ivanov"));
            outputStream.writeObject(new ExternalizableAnimal("Mouse"));
            outputStream.flush();
        }
    }
}
