package com.tomslabs.exercises.chapter6;

public class Exercise5 {
    private class Arr {
        public static <T> T[] swap(int i, int j, T... vals) {
            T temp = vals[i];
            vals[i] = vals[j];
            vals[j] = temp;
            return vals;
        }
    }

    public static void main(String[] args) {
//        Double[] res = Arr.<Double>swap(0, 1, 1.5, 2, 3);
        Double[] res = Arr.<Double>swap(0, 1, 1.5, 2.0, 3.0);
        Number[] res3 = Arr.<Number>swap(0, 1, 1.5, 2, 3);
        String[] strings = Arr.<String>swap(0, 1, "1.5", "2", "3");
        Object[] res2 = Arr.<Object>swap(0, 1, 1.5, 2, 3);
    }
}
