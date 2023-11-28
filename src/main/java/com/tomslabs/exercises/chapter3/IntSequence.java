package com.tomslabs.exercises.chapter3;

public interface IntSequence {
    boolean hasNext();

    int next();

    static IntSequence constant(int constant) {
        return new IntSequence() {
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public int next() {
                return constant;
            }
        };
    }

    static IntSequence of(int... ints) {
        return new IntSequence() {
            int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < ints.length;
            }

            @Override
            public int next() {
                int next = ints[currentIndex];
                currentIndex++;
                return next;
            }
        };
    }
}
