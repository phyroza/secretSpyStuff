package com.tomslabs.exercises.chapter7;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Exercise14 {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>(Map.of("aaa", 1, "bbb", 2, "ccc", 3, "ddd", 4));

        Set<String> keys = map.keySet();
        Collection<Integer> values = map.values();
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        System.out.println("keys = " + keys);
        System.out.println("values = " + values);
        System.out.println("entries = " + entries);

        map.put("eee", 5);
        System.out.println("\nkeys = " + keys);
        System.out.println("values = " + values);
        System.out.println("entries = " + entries);

        try {
            entries.add(new AbstractMap.SimpleEntry<>("ffff", 6));
        } catch (UnsupportedOperationException e) {
            System.out.println("entrySet is unmodifiable");
        }

        try {
            keys.add("laa");
        } catch (UnsupportedOperationException e) {
            System.out.println("keySet is unmodifiable");
        }

        try {
            values.add(7);
        } catch (UnsupportedOperationException e) {
            System.out.println("valueSet is unmodifiable");
        }
    }
}
