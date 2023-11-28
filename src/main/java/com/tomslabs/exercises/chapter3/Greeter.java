package com.tomslabs.exercises.chapter3;

record Greeter(String target, int n) implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < n; ++i) {
            System.out.printf("Hello, %s%n", target);
        }
    }
}
