package com.tomslabs.exercises.chapter9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exercise4 {

    private static File file;

    static {
        try {
            file = new File(Exercise4.class.getResource("/text/wordsFile.txt").toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        runAndMeasure("Scanner",
                () -> {
                    try {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNext()) {
                            scanner.nextLine();
                        }
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
        );

        runAndMeasure("BufferedReader",
                () -> {
                    try {
                        BufferedReader bufferedReader = Files.newBufferedReader(file.toPath());
                        while (bufferedReader.readLine() != null) {
                            bufferedReader.readLine();
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
        );

        runAndMeasure("BufferedReaderLines",
                () -> {
                    try {
                        BufferedReader bufferedReader = Files.newBufferedReader(file.toPath());
                        bufferedReader.lines().collect(Collectors.toList());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
    }

    private static void runAndMeasure(String name, Runnable runnable) {
        long start = System.currentTimeMillis();
        runnable.run();
        long end = System.currentTimeMillis();
        System.out.println(name + ": " + (end - start));
    }
}
