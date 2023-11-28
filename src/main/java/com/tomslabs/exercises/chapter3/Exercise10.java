package com.tomslabs.exercises.chapter3;

public class Exercise10 {

    private static class Runner {
        public static void runTogether(Runnable... tasks) {
            for (Runnable task : tasks) {
                new Thread(task).start();
            }
        }

        public static void runInOrder(Runnable... tasks) {
            for (Runnable task : tasks) {
                task.run();
            }
        }
    }

    public static void main(String[] args) {
        Greeter johnsGreeter = new Greeter("John", 10);
        Greeter janesGreeter = new Greeter("Jane", 10);
        Runner.runInOrder(johnsGreeter, janesGreeter);
        System.out.println("_____________________");
        Runner.runTogether(johnsGreeter, janesGreeter);
    }
}
