package com.tomslabs.exercises.chapter6;

import java.util.ArrayList;

public class Exercise7 {

    public static void main(String[] args) {
        String pair1Max = new Pair<>("a", "b").getMax();
        String pair2Min = new Pair<>("a", "b").getMin();

        System.out.println("pair1Max = " + pair1Max);
        System.out.println("pair2Min = " + pair2Min);
    }

    private static class Pair<E extends Comparable<? super E>> {
        E first;
        E second;

        public Pair(E first, E second) {
            this.first = first;
            this.second = second;
        }

        public E getFirst() {
            return first;
        }

        public void setFirst(E first) {
            this.first = first;
        }

        public E getSecond() {
            return second;
        }

        public void setSecond(E second) {
            this.second = second;
        }

        E getMax() {
            return first.compareTo(second) < 0 ? first : second;
        }

        E getMin() {
            return first.compareTo(second) >= 0 ? first : second;
        }
    }
}
