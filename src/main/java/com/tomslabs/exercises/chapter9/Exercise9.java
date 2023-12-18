package com.tomslabs.exercises.javaImpatnient.chapter9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Exercise9 {
    public static void main(String[] args) throws MalformedURLException {
        try {
            URL testUrl = new URL("https://authenticationtest.com/HTTPAuth/");
            URLConnection connection = testUrl.openConnection();

            String encodedCreds = Base64.getEncoder().encodeToString("user:pass".getBytes(StandardCharsets.UTF_8));
            connection.setRequestProperty("Authorization", "Basic " + encodedCreds);

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            bufferedReader.lines().forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
