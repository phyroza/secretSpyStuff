package com.tomslabs.exercises.javaImpatnient.chapter3;

public class Exercise6 {
    public static void main(String[] args) {
        SquareSequence squareSequence = new SquareSequence();
        for (int i = 0; i < 10000; i++) {
            System.out.println("squareSequence.next(); = " + squareSequence.next());
        }
    }
}
