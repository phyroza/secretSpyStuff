package com.tomslabs.exercises.chapter3;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class Exercise11 {
    private static File[] getAllSubDirs(File root) {
        return root.listFiles(File::isDirectory);
    }

    private static File[] getAllSubDirs2(File root) {
        return root.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });
    }

    private static void printFiles(File[] allSubDirs) throws IOException {
        for (File dir : allSubDirs) {
            System.out.println(dir);
        }
    }

    public static void main(String[] args) throws IOException {
        printFiles(getAllSubDirs(new File("C:/Program Files")));
        System.out.println("_______________");
        printFiles(getAllSubDirs2(new File("C:/Program Files")));
    }
}
