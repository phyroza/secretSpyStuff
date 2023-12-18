package com.tomslabs.exercises.javaImpatnient.chapter6;

import java.util.ArrayList;
import java.util.Optional;

public class Exercise3 {

    public static void main(String[] args) {
        Table<String, Integer> table = new Table<>();
        table.setKeyValue("a", 1);
        table.setKeyValue("b", 2);
        table.setKeyValue("c", 3);
        table.setKeyValue("d", 4);
        table.setKeyValue("f", 5);
        System.out.println("table = " + table);

        Integer c = table.getKeyValue("c");
        Table.Entry<String, Integer> bEntry = table.getEntry("b");
        System.out.println(bEntry);
        table.removeKey("d");
        System.out.println("c value = " + c);
        System.out.println("table = " + table);

    }

    private static class Table<K, V> {
        ArrayList<Entry<K, V>> list = new ArrayList<>();

        private static class Entry<K, V> {
            K key;
            V value;


            public Entry(K key, V value) {
                this.key = key;
                this.value = value;
            }

            public K getKey() {
                return key;
            }

            public V getValue() {
                return value;
            }

            public void setValue(V value) {
                this.value = value;
            }

            @Override
            public String toString() {
                return getKey().toString() + "->" + getValue().toString();
            }
        }

        @Override
        public String toString() {
            return list.stream().map(Entry::toString).toList().toString();
        }

        V getKeyValue(K key) {
            Optional<Entry<K, V>> first = list.stream().filter(kvEntry -> kvEntry.getKey().equals(key)).findFirst();
            return first.map(Entry::getValue).orElse(null);
        }

        Entry<K, V> getEntry(K key) {
            Optional<Entry<K, V>> first = list.stream().filter(kvEntry -> kvEntry.getKey().equals(key)).findFirst();
            return first.orElse(null);
        }

        void setKeyValue(K key, V value) {
            Entry<K, V> existingValue = getEntry(key);
            if (existingValue == null) {
                list.add(new Entry<>(key, value));
            } else {
                existingValue.setValue(value);
            }
        }

        void removeKey(K keyToRemove) {
            list.removeIf(kvEntry -> kvEntry.getKey().equals(keyToRemove));
        }
    }
}
