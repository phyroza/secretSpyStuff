package com.tomslabs.exercises.chapter3;

public class Exercise4 {
    public static void main(String[] args) {
        IntSequence intSequence = IntSequence.of(5, 7, 3, 7, 88, 3, 2, 767, 66, 3);
        while (intSequence.hasNext()) {
            System.out.println("intSequence.next() = " + intSequence.next());
        }
    }
}
