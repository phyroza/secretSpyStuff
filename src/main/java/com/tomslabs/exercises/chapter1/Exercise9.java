package com.tomslabs.exercises.chapter1;

import java.util.Scanner;

public class Exercise9 {
    public static void main(String[] args) {
        String w1 = "Word";
        Scanner sc = new Scanner(System.in);
        String w2 = sc.next();

        System.out.println("Equals: " + Boolean.toString(w1.equals(w2)) + " Operator == " + Boolean.toString(w1 == w2));
    }
}
