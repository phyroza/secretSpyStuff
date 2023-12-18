package com.tomslabs.exercises.javaImpatnient.chapter3;

import java.util.*;

public class Exercise8 {
    static void luckySort(ArrayList<String> strings, Comparator<String> comp) {
        ArrayList<String> unsortedStrings = new ArrayList<>(strings);
        strings.sort(comp);
        int iterations = 0;
        while (!unsortedStrings.equals(strings)) {
            Collections.shuffle(unsortedStrings);
            iterations++;
        }
        System.out.println("Sorted with shuffle iterations = " + iterations);
    }

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>(List.of("lalala", "blebleble", "zonk", "lol", "aaa", "wutwut", "ccc"));
        luckySort(strings, Comparator.comparing(String::length));
        luckySort(strings, Comparator.naturalOrder());
    }
}
