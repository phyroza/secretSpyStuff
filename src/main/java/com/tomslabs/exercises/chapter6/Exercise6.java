package com.tomslabs.exercises.javaImpatnient.chapter6;

import java.util.ArrayList;
import java.util.List;

public class Exercise6 {
    private static <E> void addArrayListToOther(ArrayList<E> dest, ArrayList<? extends E> from) {
        dest.addAll(from);
    }

    private static <E> void addArrayListToOther2(ArrayList<? super E> dest, ArrayList<E> from) {
        dest.addAll(from);
    }

    public static void main(String[] args) {
        ArrayList<Number> numbers = new ArrayList<>(List.of(1.0, 2, 5, 10, 12.0));
        ArrayList<Double> doubles = new ArrayList<>(List.of(1.0, 2.0, 3.0));

        addArrayListToOther(numbers, doubles);
        System.out.println("numbers = " + numbers);
        addArrayListToOther2(numbers, doubles);
        System.out.println("numbers = " + numbers);
    }
}
