package com.tomslabs.exercises.chapter1;

public class Exercise21 {
    public static void main(String[] args) {
        System.out.println(average(1,2,3,4));

        try {
            System.out.println(average());
        } catch (Exception e) {
            System.out.println("Should've provided the value. I caught this exception, others may not.");
        }
    }

    public static double average(double... vals){
        if (vals.length == 0)
            throw new IllegalArgumentException("Must provide at least 1 value.");

        double sum = 0;
        for (double val : vals) {
            sum+=val;
        }
        return sum / vals.length;
    }
}
