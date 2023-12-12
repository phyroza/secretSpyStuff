package com.tomslabs.exercises.chapter9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise10 {

    private static Pattern digitPattern = Pattern.compile("\\p{Digit}+");
    private static Pattern nonDigitPattern = Pattern.compile("\\P{Digit}+");

    public static void main(String[] args) {
        System.out.println(extractNumbersA("10 zonk kot dsk 21;l22,flfl;d93393 jsjda 202 3m231m- 3n21n"));
        System.out.println(extractNumbersB("10 zonk kot dsk 21;l22,flfl;d93393 jsjda 202 3m231m- 3n21n"));
    }

    private static List<Integer> extractNumbersA(String data) {
        Matcher matcher = digitPattern.matcher(data);
        ArrayList<Integer> nums = new ArrayList<>();
        while (matcher.find()) {
            nums.add(Integer.parseInt(matcher.group()));
        }

        return nums;
    }

    private static List<Integer> extractNumbersB(String data) {
        String[] numStrings = nonDigitPattern.split(data);
        return Arrays.stream(numStrings).mapToInt(Integer::parseInt).boxed().toList();
    }
}
