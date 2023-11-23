package com.tomslabs.exercises.chapter1;

import java.util.Scanner;

public class Exercise11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();

        for (int i=0; i<word.length();++i){
            word.codePoints().filter(a -> a > 127).forEach(a -> {
                System.out.println(Character.toString(a));
                System.out.println(String.format("\\u%04x", a));
            });
        }

    }
}
