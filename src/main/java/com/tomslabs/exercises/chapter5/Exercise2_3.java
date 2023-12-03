package com.tomslabs.exercises.chapter5;

import java.io.IOException;
import java.util.ArrayList;

import static com.tomslabs.exercises.chapter5.Exercise1.DATA_DIR;

public class Exercise2_3 {
    static double sumOfValues(String filename) throws IOException {
        ArrayList<Double> doubles = Exercise1.readValues(filename);
        Double sum = 0.0;
        for (Double aDouble : doubles) {
            sum += aDouble;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(sumOfValues(DATA_DIR + "doubleValues.txt"));
    }
}
