package ru.csc.java.networking.uri;

import java.net.URI;

public class UriDemo {

    public static void main(String[] args) throws Exception {
        dumpUriComponents(new URI("mailto:java-net@java.sun.com"));

        dumpUriComponents(new URI("http://java.sun.com/j2se/1.3/"));


        URI base = new URI("http://user@java.sun.com:333/j2se/1.3/?query#cut");
        dumpUriComponents(base);
        URI resolved = base.resolve("../1.4/index.html");
        dumpUriComponents(resolved);

        URI relativized = base.relativize(new URI("http://user@java.sun.com:333/j2se/1.3/index.html"));
        dumpUriComponents(relativized);
    }

    private static void dumpUriComponents(URI uri) {
        System.out.println("-- " + uri + " --");
        System.out.println("Scheme:                 " + uri.getScheme());
        System.out.println("Scheme-specific part:   " + uri.getSchemeSpecificPart());
        System.out.println("Authority:              " + uri.getAuthority());
        System.out.println("User info:              " + uri.getUserInfo());
        System.out.println("Host:                   " + uri.getHost());
        System.out.println("Port:                   " + uri.getPort());
        System.out.println("Path:                   " + uri.getPath());
        System.out.println("Query:                  " + uri.getQuery());
        System.out.println("Fragment:               " + uri.getFragment());
        System.out.println();
    }
}
