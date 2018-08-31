package ru.csc.java.networking.socket.tcp.echo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class EchoServer {

    private static final Logger LOG = Logger.getLogger(EchoServer.class.getName());

    public static void main(String[] args) throws Exception {
        try (ServerSocket serverSocket = new ServerSocket(11111)) {
            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    serveClient(socket);
                }
            }
        }
    }

    private static void serveClient(Socket socket) throws IOException {
        LOG.info("Serving client " + socket.getRemoteSocketAddress());

        try (DataInputStream inputStream = new DataInputStream(socket.getInputStream());
             DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream())) {

            while (true) {
                String request = inputStream.readUTF();

                LOG.info("Request: " + request);
                outputStream.writeUTF(request);
                outputStream.flush();
            }
        } catch (EOFException e) {
            // client closed connection
        }
    }
}
