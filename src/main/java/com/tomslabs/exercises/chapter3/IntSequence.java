package com.tomslabs.exercises.chapter3;

public interface IntSequence {
    boolean hasNext();

    int next();

    static IntSequence of(int... ints) {
        return new IntSequence() {
            private final int[] intsArray = ints;
            int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < intsArray.length;
            }

            @Override
            public int next() {
                int next = intsArray[currentIndex];
                currentIndex++;
                return next;
            }
        };
    }
}
