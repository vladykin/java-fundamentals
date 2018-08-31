package ru.csc.java.networking.socket.datagram;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class DatagramClient {

    public static void main(String[] args) throws Exception {
        try (DatagramSocket socket = new DatagramSocket()) {
            DatagramPacket packet = encodePacket("Hello world!");
            packet.setSocketAddress(new InetSocketAddress("localhost", 11111));
            socket.send(packet);
        }
    }

    private static DatagramPacket encodePacket(String text) {
        byte[] bytes = text.getBytes(StandardCharsets.UTF_8);
        return new DatagramPacket(bytes, bytes.length);
    }
}
