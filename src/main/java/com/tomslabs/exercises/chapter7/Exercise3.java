package com.tomslabs.exercises.javaImpatnient.chapter7;

import java.util.HashSet;
import java.util.Set;

public class Exercise3 {
    static Set<String> setA = new HashSet<>(Set.of("Apple", "Bannana", "Car", "Phone"));
    static Set<String> setB = new HashSet<>(Set.of("Car", "Phone", "bike"));
    static Set<String> setC = new HashSet<>(Set.of("smth"));

    public static void main(String[] args) {
        Set<String> aCopy = new HashSet<>(setA);
        aCopy.retainAll(setB);
        System.out.println("aCopy = " + aCopy);

        Set<String> aCopy2 = new HashSet<>(setA);
        aCopy2.removeAll(setB);
        System.out.println("aCopy2 = " + aCopy2);

        setA.addAll(setC);
        System.out.println("setA = " + setA);
    }
}
