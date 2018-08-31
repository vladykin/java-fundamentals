package ru.csc.java.networking.http;

import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;

import java.io.IOException;

public class ApacheHttpClient {

    public static void main(String[] args) throws IOException {
        Content content = Request.Get("http://localhost:11111/")
                .execute().returnContent();

        System.out.println(content);
    }
}
