package com.tomslabs.exercises.javaImpatnient.chapter10;

import java.util.Arrays;
import java.util.Random;

public class Exercise2 {
    public static void main(String[] args) {
        int size = findSmallestArrWhereParallelIsFaster();
        System.out.println("Parallel faster starting size = " + size);
    }

    private static int findSmallestArrWhereParallelIsFaster() {
        int currentSize = 2;
        Random random = new Random();
        long time1 = 1;
        long time2 = 0;
        while (time1 >= time2) {
            int[] ints1 = random.ints(currentSize).toArray();
            int[] ints2 = Arrays.copyOf(ints1, ints1.length);

            time1 = measureOperation(() -> Arrays.sort(ints1));
            time2 = measureOperation(() -> Arrays.parallelSort(ints2));

            currentSize++;
        }

        return currentSize;
    }

    private static long measureOperation(Runnable r) {
        long start = System.currentTimeMillis();
        r.run();
        long end = System.currentTimeMillis();
        return end - start;
    }
}
