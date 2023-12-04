package com.tomslabs.exercises.chapter6;

import java.util.BitSet;
import java.util.HashMap;

public class Exercise18 {

    public static final int NBITS = 256;

    // wymazywanie do Object, uzyc boxingu
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        String key = "smth";
        String keysValue = map.computeIfAbsent(key, k -> k + "-value");
        System.out.println("keysValue = " + keysValue);

        BitSet bitSet = new BitSet(NBITS);
        bitSet.set(0, NBITS, true);
        bitSet.stream().forEach(i -> bitSet.set(i, i % 2 != 0));
        System.out.println("bitSet = " + bitSet.toString());
    }
}
