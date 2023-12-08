package com.tomslabs.exercises.chapter8;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Exercise3 {
    private static final int[] ints = {1, 4, 9, 16};

    public static void main(String[] args) {
        Stream<int[]> intz = Stream.of(ints);
        IntStream intzz = IntStream.of(ints);
    }
}
