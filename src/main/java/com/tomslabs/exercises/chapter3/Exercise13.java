package com.tomslabs.exercises.chapter3;

import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Comparator;

public class Exercise13 {
    static void sortFiles(File[] file) {
        Arrays.sort(file, Comparator.comparing(File::isFile).thenComparing(File::getName));
    }

    public static void main(String[] args) {
        File[] rootFiles = new File("C:\\Windows").listFiles();
        if (rootFiles != null) {
            System.out.println("pre-sorted:");
            for (File rootFile : rootFiles) {
                System.out.println(rootFile);
            }

            System.out.println("sorted:");
            sortFiles(rootFiles);
            for (File rootFile : rootFiles) {
                System.out.println(rootFile);
            }
        }
    }
}
