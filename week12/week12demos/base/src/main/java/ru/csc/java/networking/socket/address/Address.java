package ru.csc.java.networking.socket.address;

import java.net.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;

public class Address {

    public static void main(String[] args) throws Exception {
        InetAddress[] allLocalAddresses = InetAddress.getAllByName("localhost");
        System.out.println(Arrays.toString(allLocalAddresses));


        Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
        for (NetworkInterface netint : Collections.list(nets)) {
            displayInterfaceInformation(netint);
        }

        InetAddress inetAddress = InetAddress.getByAddress(new byte[]{127, 0, 0, 1});

        SocketAddress socketAddress = new InetSocketAddress(inetAddress, 13333);
        System.out.println(socketAddress);
    }

    private static void displayInterfaceInformation(NetworkInterface netint) throws SocketException {
        System.out.printf("Display name: %s\n", netint.getDisplayName());
        System.out.printf("Name: %s\n", netint.getName());
        Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();
        for (InetAddress inetAddress : Collections.list(inetAddresses)) {
            System.out.printf("InetAddress: %s\n", inetAddress);
        }
        System.out.printf("\n");
    }
}
