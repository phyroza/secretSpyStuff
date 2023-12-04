package com.tomslabs.exercises.chapter6;

import java.util.ArrayList;
import java.util.function.Function;

public class Exercise15 {

    public static void main(String[] args) {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("aa");
        stringList.add("bbb");
        stringList.add("cccc");
        stringList.add("ddddd");
        stringList.add("fffffff");

        ArrayList<Integer> integersA = mapA(stringList, String::length);
        System.out.println("integersA = " + integersA);
        ArrayList<Integer> integersB = mapB(stringList, String::length);
        System.out.println("integersB = " + integersB);
    }

    public static <T, R> ArrayList<R> mapA(ArrayList<T> elements, Function<T, R> function) {
        ArrayList<R> resultList = new ArrayList<>();
        for (T element : elements) {
            resultList.add(function.apply(element));
        }
        return resultList;
    }

    public static <T, R> ArrayList<R> mapB(ArrayList<T> elements, Function<T, R> function) {
        return new ArrayList<>(elements.stream().map(function).toList());
    }
}
