package com.tomslabs.exercises.javaImpatnient.chapter8;

public class Exercise6 {
    public static void main(String[] args) {
        String s = "String;";
        System.out.println("lettersOnly(s) = " + lettersOnly(s));
    }

    static boolean lettersOnly(String s) {
        return s.codePoints().filter(i -> !Character.isAlphabetic(i)).findAny().isEmpty();
    }
}
