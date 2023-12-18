package com.tomslabs.exercises.javaImpatnient.chapter8;

import java.util.List;
import java.util.stream.Stream;

public class Exercise4 {
    public static void main(String[] args) {
        List<Long> tenRandomLongs = getRandomInfiniteStream(25214903917L, 11, (long) Math.pow(2, 48)).limit(10).toList();
        System.out.println("tenRandomLongs = " + tenRandomLongs);
    }

    private static Stream<Long> getRandomInfiniteStream(long a, long c, long m) {
        return Stream.iterate(13L, prev -> ((a * prev + c) % m));
    }
}

