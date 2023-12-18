package com.tomslabs.exercises.javaImpatnient.chapter7;

import java.util.LinkedHashMap;
import java.util.Map;

public class Exercise13 {
    private static class Cache<K, V> extends LinkedHashMap<K, V> {
        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return true;
        }
    }
}
