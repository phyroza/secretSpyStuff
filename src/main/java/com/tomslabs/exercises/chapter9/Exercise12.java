package com.tomslabs.exercises.chapter9;

import java.util.regex.Pattern;

public class Exercise12 {
    public static void main(String[] args) {
        String dateTimeString = "Spy left house at 2023-12-12 15:12 and came back at 2023-12-12 19:43";
        Pattern pattern = Pattern.compile("(\\p{Digit}{4})-\\p{Digit}{2}-\\p{Digit}{2}\\s*(\\p{Digit}{2}):\\p{Digit}{2}");

        String hiddenString = pattern.matcher(dateTimeString).replaceAll("--HIDDEN--");
        System.out.println(hiddenString);
    }
}
