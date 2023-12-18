package com.tomslabs.exercises.javaImpatnient.chapter10;

public class TestClass {
    static int sum(int... vals) {
        int sum = 0;
        for (int val : vals) {
            sum = val;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sum());
    }
}
