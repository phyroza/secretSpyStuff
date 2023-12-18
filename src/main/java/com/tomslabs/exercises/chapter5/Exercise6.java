package com.tomslabs.exercises.javaImpatnient.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Exercise6 {
    private static void doSmthA() {
        BufferedReader in = null;

        try {
            in = Files.newBufferedReader(Paths.get("C:/training/data/words"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.err.println("Ex: " + e.getMessage());
        } finally {
            try {
                if (in != null) in.close();
            } catch (IOException e) {
                System.err.println("Error closing input: " + e.getMessage());
            }
        }
    }

    private static void doSmthB() {
        BufferedReader in = null;

        try {
            in = Files.newBufferedReader(Paths.get("C:/training/data/words"), StandardCharsets.UTF_8);
            try {
                in.close();
            } catch (IOException e) {
                System.err.println("Ex closing words file: " + e.getMessage());
            }
        } catch (IOException e) {
            System.err.println("Ex opening words file: " + e.getMessage());
        }
    }

    private static void doSmthC() {
        try (BufferedReader in = Files.newBufferedReader(Paths.get("C:/training/data/words"), StandardCharsets.UTF_8);) {
            System.out.println("line = " + in.readLine());
        } catch (IOException e) {
            System.err.println("Ex: " + e.getMessage());
        }
    }
}
