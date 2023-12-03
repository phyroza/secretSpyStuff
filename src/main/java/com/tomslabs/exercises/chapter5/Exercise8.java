package com.tomslabs.exercises.chapter5;

import java.util.Scanner;

public class Exercise8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double aDouble = scanner.nextDouble();
        // not valid anymore, does not close the resource but returns to previous position allowing for next attempt
    }
}
