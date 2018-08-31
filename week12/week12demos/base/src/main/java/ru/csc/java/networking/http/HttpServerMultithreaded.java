package ru.csc.java.networking.http;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HttpServerMultithreaded {

    private static final Logger LOGGER = Logger.getLogger(HttpServerMultithreaded.class.getName());

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(80);
        ExecutorService service = Executors.newFixedThreadPool(10);
        while (true) {
            Socket socket = serverSocket.accept();
            service.submit(() -> serveClient(socket));
        }
    }

    private static Void serveClient(Socket socket) throws Exception {
        LOGGER.log(Level.INFO, "Serving client {0}", socket.getRemoteSocketAddress());

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Writer writer = new OutputStreamWriter(socket.getOutputStream())) {

            for (String line = reader.readLine(); line != null && !line.isEmpty(); line = reader.readLine()) {
                LOGGER.log(Level.INFO, "Header:: {0}", line);
            }
            writer.write("HTTP/1.0 200 OK\r\n");
            writer.write("Content-Type: text/html\r\n\r\n");
            writer.write("<h1>Hello world!</h1>\r\n");

        } finally {
            socket.close();
        }

        return null;
    }
}
