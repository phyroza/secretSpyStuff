package com.tomslabs.exercises.javaImpatnient.chapter7;

import java.util.Comparator;
import java.util.HashSet;

public class Exercise1 {

    public static void main(String[] args) {
        EraSieve eraSieve64 = new EraSieve(64);
        eraSieve64.doSieving();
    }

    private static class EraSieve {
        final int N;
        private final HashSet<Integer> numbersSet;

        public EraSieve(int n) {
            this.N = n;
            numbersSet = new HashSet<>(N);
            for (int i = 2; i <= N; ++i) {
                numbersSet.add(i);
            }
        }

        public void doSieving() {
            Integer smallestNum = 2;
            while (smallestNum * smallestNum < N) {
                for (int i = 2; i * smallestNum <= N; i++) {
                    numbersSet.remove(i * smallestNum);
                }
                Integer finalSmallestNum = smallestNum;
                smallestNum = numbersSet.stream().filter(num -> num > finalSmallestNum)
                        .min(Comparator.comparingInt(Integer::intValue)).get();
            }

            System.out.println(numbersSet);
        }
    }
}
