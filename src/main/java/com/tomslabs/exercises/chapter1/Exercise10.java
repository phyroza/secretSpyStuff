package com.tomslabs.exercises.javaImpatnient.chapter1;

import java.util.Random;

public class Exercise10 {
    public static void main(String[] args) {
        Random random = new Random();
        long sum = random.longs(1).sum();
        System.out.println(Long.toString(sum, 36));
    }
}
