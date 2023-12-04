package com.tomslabs.exercises.chapter6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Exercise9 {

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>(List.of("ziom", "kwiatek", "auto", "zonk", "alicja", "zorro"));
        Pair<String> stringPair = Arrays.firstAndLast(strings);
        System.out.println("stringPair = " + stringPair);
    }

    private static class Arrays {
        public static <E extends Comparable<? super E>> Pair<E> firstAndLast(ArrayList<? extends E> listOfE) {
            listOfE.sort(Comparator.naturalOrder());
            return new Pair<>(listOfE.get(0), listOfE.get(listOfE.size() - 1));
        }
    }

}
