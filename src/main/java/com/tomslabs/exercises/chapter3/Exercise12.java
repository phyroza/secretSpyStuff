package com.tomslabs.exercises.javaImpatnient.chapter3;

import java.io.File;

public class Exercise12 {
    private static File[] listFiles(File root, String extension) {
        return root.listFiles(file -> file.isFile() && file.getName().endsWith(extension));
    }

    public static void main(String[] args) {
        File root = new File("C:\\Windows");
        String extension = ".exe";
        File[] files = listFiles(root, extension);
        for (File file : files) {
            System.out.println("file = " + file);
        }

        // root & extension
    }
}
