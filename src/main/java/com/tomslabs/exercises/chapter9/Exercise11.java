package com.tomslabs.exercises.chapter9;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.regex.Pattern;


public class Exercise11 {
    public static void main(String[] args) throws URISyntaxException {
        URL resource = Exercise11.class.getResource("/text/wordsFile.txt");
        String path = new File(resource.toURI()).getAbsolutePath();

        System.out.println(path);
        String[] parts = extractPathParts(path);
        System.out.println(List.of(parts));
    }

    private static String[] extractPathParts(String path) {
        return Pattern.compile("[\\\\\\.]").split(path);
    }
}
