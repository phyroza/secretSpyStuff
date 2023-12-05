package com.tomslabs.exercises.chapter7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Exercise2 {
    static List<String> list = List.of("dodaj", "wszystkie", "liczby", "smth", "dodaj");

    public static ArrayList<String> uppercaseA(ArrayList<String> list) {
        Iterator<String> iterator = list.iterator();
        ArrayList<String> newList = new ArrayList<>();
        while (iterator.hasNext()) {
            newList.add(iterator.next().toUpperCase());
        }
        list.clear();
        list.addAll(newList);

        return list;
    }

    public static ArrayList<String> uppercaseB(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i).toUpperCase());
        }
        return list;
    }

    private static ArrayList<String> uppercaseC(ArrayList<String> list) {
        list.replaceAll(String::toUpperCase);
        return list;
    }

    public static void main(String[] args) {
        System.out.println("listA = " + uppercaseA(new ArrayList<>(list)));
        System.out.println("listB = " + uppercaseB(new ArrayList<>(list)));
        System.out.println("listC = " + uppercaseC(new ArrayList<>(list)));
    }
}
