package com.tomslabs.exercises.chapter7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Exercise6 {
    static void processMap(Map<String, ? extends Set<Integer>> map) {
        System.out.println("map = " + map);
    }

    public static void main(String[] args) {
        HashMap<String, HashSet<Integer>> theMap = new HashMap<>(Map.of(
                "a", new HashSet<>(Set.of(1)),
                "b", new HashSet<>(Set.of(1, 2)),
                "c", new HashSet<>(Set.of(1, 2, 3)),
                "d", new HashSet<>(Set.of(1, 2, 3, 4))
        ));
        processMap(theMap);
    }
}
