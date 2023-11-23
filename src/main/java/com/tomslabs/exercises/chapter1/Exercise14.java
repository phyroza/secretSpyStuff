package com.tomslabs.exercises.chapter1;

import java.util.Scanner;

public class Exercise14 {
    public static void main(String[] args) {
        String stringToCheck = new Scanner(System.in).next();

        String fullName;
        switch (stringToCheck) {
            case "lol" -> fullName = "Laughing out loud";
            case "wut" -> fullName = "what";
            default -> fullName = "dunno man";
        }
        System.out.println("fullName = " + fullName);
    }
}
