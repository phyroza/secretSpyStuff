package com.tomslabs.exercises.chapter6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Exercise12 {
    public static <T> void minmax(List<T> elements, Comparator<? super T> comp, List<? super T> result) {
        ArrayList<T> sortedWithComp = new ArrayList<>(elements);
        sortedWithComp.sort(comp);

        result.add(sortedWithComp.get(0));
        result.add(sortedWithComp.get(sortedWithComp.size() - 1));
    }

    public static void main(String[] args) {
        List<String> names = List.of("ffff", "aaa", "bbb", "zzzz", "ccc", "dddd");
        ArrayList<CharSequence> result = new ArrayList<>();
        minmax(names, Comparator.naturalOrder(), result);
        System.out.println("result = " + result);
    }
}
