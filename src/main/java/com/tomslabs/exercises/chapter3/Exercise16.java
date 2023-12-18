package com.tomslabs.exercises.javaImpatnient.chapter3;

public class Exercise16 {
    public static void main(String[] args) {
        IntSequence randomInts = IntSequence.randomInts(0, 100);
        for (int i = 0; i < 100; i++)
            System.out.println(randomInts.next());
    }
}
