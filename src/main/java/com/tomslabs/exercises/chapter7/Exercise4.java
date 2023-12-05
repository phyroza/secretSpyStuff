package com.tomslabs.exercises.chapter7;

import java.util.HashSet;
import java.util.Set;

public class Exercise4 {
    public static void main(String[] args) {
        HashSet<String> strs = new HashSet<>(Set.of("1", "2", "3"));
        for (String str : strs) {
            strs.add("lol");
        }
    }
}
