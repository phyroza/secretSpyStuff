package com.tomslabs.exercises.chapter1;

import java.util.Scanner;

public class Exercise8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();

        for (int i = 0; i < word.length(); i++) {
            for (int j = word.length(); j > i; j--) {
                System.out.println(word.substring(i, j));
            }
        }
    }
}
