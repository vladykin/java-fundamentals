package ru.compscicenter.java.demos.d06;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Stream;

public class ExceptionalCases2 {

    public static void main(String[] args) throws MalformedURLException {
        Stream<URL> urls = Stream.of(
                new URL("http://ya.ru"),
                new URL("http://google.com"),
                new URL("http://mail.ru"),
                new URL("http://yahoo.com"));

        urls
                .map(ExceptionalCases2::tryDownload)
                .forEach(System.out::println);
    }


    private static Try<String> tryDownload(URL url) {
        return Try.of(() -> ExceptionalCases2.download(url));
    }

    private static String download(URL url) throws IOException {
        if (Math.random() < 0.95) {
            return "Content of " + url;
        } else {
            throw new IOException("Error downloading " + url);
        }
    }
}
