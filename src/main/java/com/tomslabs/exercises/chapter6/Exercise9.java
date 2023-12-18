package com.tomslabs.exercises.javaImpatnient.chapter6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Exercise9 {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>(List.of("ziom", "kwiatek", "auto", "zonk", "alicja", "zorro"));
        System.out.println("strings = " + strings);

        Pair<String> stringPair = Arrays.firstAndLast(strings);
        System.out.println("stringPair = " + stringPair);

        String maxString = Arrays.max(strings);
        System.out.println("maxString = " + maxString);

        String minString = Arrays.min(strings);
        System.out.println("minString = " + minString);
    }


    private static class Arrays {
        public static <E extends Comparable<? super E>> Pair<E> firstAndLast(ArrayList<? extends E> listOfE) {
            return new Pair<>(listOfE.get(0), listOfE.get(listOfE.size() - 1));
        }


        public static <E extends Comparable<? super E>> E min(ArrayList<? extends E> listOfE) {
            ArrayList<? extends E> copiedArray = new ArrayList<>(listOfE);
            copiedArray.sort(Comparator.naturalOrder());
            return copiedArray.get(0);
        }

        public static <E extends Comparable<? super E>> E max(ArrayList<? extends E> listOfE) {
            ArrayList<? extends E> copiedArray = new ArrayList<>(listOfE);
            copiedArray.sort(Comparator.naturalOrder());
            return copiedArray.get(copiedArray.size() - 1);
        }

        public static <E extends Comparable<? super E>> Pair<E> minMax(ArrayList<? extends E> listOfE) {
            ArrayList<? extends E> copiedArray = new ArrayList<>(listOfE);
            copiedArray.sort(Comparator.naturalOrder());
            return new Pair<>(copiedArray.get(0), copiedArray.get(copiedArray.size() - 1));
        }
    }

}
