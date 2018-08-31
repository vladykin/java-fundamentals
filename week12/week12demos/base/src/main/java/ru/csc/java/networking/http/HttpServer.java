package ru.csc.java.networking.http;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HttpServer {

    private static final Logger LOG = Logger.getLogger(HttpServer.class.getName());

    public static void main(String[] args) throws IOException {
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

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
            Writer writer = new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8)) {

            for (String line = reader.readLine(); line != null && !line.isEmpty(); line = reader.readLine()) {
                LOG.log(Level.INFO, "Header:: {0}", line);
            }

            writer.write("HTTP/1.1 200 OK\r\n");
            writer.write("Content-Type: text/plain; charset=UTF-8\r\n");
            writer.write("\r\n");
            writer.write("Hi there!");
        }
    }
}
