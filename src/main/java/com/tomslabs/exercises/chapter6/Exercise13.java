package com.tomslabs.exercises.chapter6;

import java.util.Comparator;
import java.util.List;

import static com.tomslabs.exercises.chapter6.Exercise12.minmax;

public class Exercise13 {
    public static <T> void maxmin(List<T> elements, Comparator<? super T> comp, List<? super T> result) {
        minmax(elements, comp, result);
        swap(result, 0, 1);
    }

    private static <T> void swap(List<T> elements, int i, int j) {
        T temp = elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, temp);
    }
}
