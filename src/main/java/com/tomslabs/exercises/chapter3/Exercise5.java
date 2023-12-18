package com.tomslabs.exercises.javaImpatnient.chapter3;

public class Exercise5 {
    public static void main(String[] args) {
        IntSequence constantSeq = IntSequence.constant(7);
        for (int i = 0; i < 10; i++) {
            System.out.println("constantSeq.next() = " + constantSeq.next());
        }
    }
}
