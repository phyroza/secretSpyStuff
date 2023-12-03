package com.tomslabs.exercises.chapter5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Exercise5 {

    static void rewriteInLowerCase() {
//        try (Scanner in = new Scanner(Paths.get("C:/training/data/words.txt"));
//             PrintWriter out = new PrintWriter("C:/training/data/wordsOutput.txt"))
        Scanner in = null;
        PrintWriter out = null;
        try {
            in = new Scanner(Paths.get("C:/training/data/words.txt"));
            out = new PrintWriter("C:/training/data/wordsOutput.txt");

            while (in.hasNext()) {
                out.println(in.next().toLowerCase());
            }

            out.close();
            in.close();

        } catch (FileNotFoundException e) {
            if (in != null) in.close();
            throw new RuntimeException("Could not create file for output", e);
        } catch (IllegalStateException | NoSuchElementException e) {
            if (out != null) out.close();
            if (in != null) in.close();
        } catch (IOException e) {
            throw new RuntimeException("Could not open file for reading", e);
        }
    }

    public static void main(String[] args) {
        rewriteInLowerCase();
    }
}
