package com.tomslabs.exercises.chapter7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.RandomAccess;

public class Exercise5 {

    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>(List.of("apple", "orange", "banana"));
        LinkedList<String> veggies = new LinkedList<>(List.of("cucumber", "tomato", "potato"));
        swap(fruits, 0, 2);
        swap(veggies, 0, 2);
        System.out.println("fruits = " + fruits);
        System.out.println("veggies = " + veggies);
    }

    public static void swap(List<?> list, int i, int j) {
        if (list instanceof RandomAccess) {
            swapHelper(list, i, j);
        } else {
            swapHelperNoRandomAccess(list, i, j);
        }
    }

    private static <E> void swapHelperNoRandomAccess(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }

    public static <E> void swapHelper(List<E> list, int i, int j) {
        E temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
