package com.tomslabs.exercises.chapter7;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Exercise4 {
    public static void main(String[] args) {
        HashSet<String> strs = new HashSet<>(Set.of("1", "2", "3"));
        for (Iterator<String> iterator = strs.iterator(); iterator.hasNext(); ) {
            String str = iterator.next();
            strs.add("lol");
        }
    }
}
