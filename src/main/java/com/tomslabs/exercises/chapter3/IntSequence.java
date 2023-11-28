package com.tomslabs.exercises.chapter3;

import java.util.random.RandomGenerator;

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

    static IntSequence randomInts(int low, int high) {
        return new RandomSequence(low, high);
    }

    class RandomSequence implements IntSequence {
        static RandomGenerator gen = RandomGenerator.getDefault();

        private final int low;
        private final int high;

        public RandomSequence(int low, int high) {
            this.low = low;
            this.high = high;
        }

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public int next() {
            return gen.nextInt(low, high);
        }
    }
}
