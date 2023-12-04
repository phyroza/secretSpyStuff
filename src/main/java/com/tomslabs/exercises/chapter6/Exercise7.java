package com.tomslabs.exercises.chapter6;

public class Exercise7 {

    public static void main(String[] args) {
        String pair1Max = new Pair<>("a", "b").getMax();
        String pair2Min = new Pair<>("a", "b").getMin();

        System.out.println("pair1Max = " + pair1Max);
        System.out.println("pair2Min = " + pair2Min);
    }

}
