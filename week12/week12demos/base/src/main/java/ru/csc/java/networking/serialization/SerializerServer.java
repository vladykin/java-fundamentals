package ru.csc.java.networking.serialization;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SerializerServer {

    private static final Logger LOG = Logger.getLogger(SerializerServer.class.getName());

    public static void main(String[] args) throws Exception {
        try (ServerSocket serverSocket = new ServerSocket(11111)) {
            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    serveClient(socket);
                }
            }
        }
    }

    private static void serveClient(Socket socket) throws Exception {
        LOG.info("Serving client " + socket.getInetAddress());

        try (ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream())) {

            while (true) {
                Object object = inputStream.readObject();
                if (object instanceof SerializablePerson) {
                    SerializablePerson person = (SerializablePerson) object;
                    LOG.log(Level.INFO, "Received SerializablePerson: {0} {1}", new Object[]{
                            person.getFirstName(), person.getLastName()});
                } else if (object instanceof ExternalizableAnimal) {
                    ExternalizableAnimal animal = (ExternalizableAnimal) object;
                    LOG.log(Level.INFO, "Received ExternalizableAnimal: {0}", new Object[]{animal.getName()});
                } else {
                    LOG.warning("Received unexpected " + object.getClass());
                }
            }
        } catch (EOFException e) {
            LOG.info("Connection closed");
        }
    }
}
