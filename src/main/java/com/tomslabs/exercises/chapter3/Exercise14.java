package com.tomslabs.exercises.chapter3;

public class Exercise14 {
    private static Runnable sequenceRunnables(Runnable[] runnables) {
        return () -> {
            for (Runnable runnable : runnables) {
                runnable.run();
            }
        };
    }

    public static void main(String[] args) {
        Runnable[] runnables = {
                () -> System.out.println("run1"),
                () -> System.out.println("run2"),
                () -> System.out.println("run3"),
                () -> System.out.println("run4"),
                () -> System.out.println("run5")
        };
        sequenceRunnables(runnables).run();
    }
}
