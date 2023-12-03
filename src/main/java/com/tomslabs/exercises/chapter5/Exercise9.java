package com.tomslabs.exercises.chapter5;

import java.util.concurrent.locks.ReentrantLock;

public class Exercise9 {

    public static void main(String[] args) {
        try (SecretWireRun run = SecretWireRun.newRun("runA")) {
            run.doStuff();
        }
    }

    private record SecretWireRun(String name) implements AutoCloseable {
        private final static ReentrantLock secretWireLock = new ReentrantLock();

        private SecretWireRun(String name) {
            this.name = name;
            secretWireLock.lock();
        }

        public static SecretWireRun newRun(String runName) {
            return new SecretWireRun(runName);
        }

        void doStuff() {
            System.out.printf("Running my stuff named: %s, using shared shit owed by wire lock = %s\n", name, secretWireLock.toString());
        }

        @Override
        public void close() {
            secretWireLock.unlock();
            System.out.println("Closing " + name + ", done using this wire lock: " + secretWireLock);
        }
    }
}
