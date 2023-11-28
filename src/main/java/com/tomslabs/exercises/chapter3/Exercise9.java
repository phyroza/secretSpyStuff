package com.tomslabs.exercises.chapter3;

public class Exercise9 {

    public static void main(String[] args) {
        Greeter johnsGreeter = new Greeter("John", 1000);
        Greeter janesGreeter = new Greeter("Jane", 1000);

        new Thread(johnsGreeter).start();
        new Thread(janesGreeter).start();
    }

    private record Greeter(String target, int n) implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < n; ++i) {
                System.out.printf("Hello, %s%n", target);
            }
        }
    }
}
