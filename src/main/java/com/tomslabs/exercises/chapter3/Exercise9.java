package com.tomslabs.exercises.javaImpatnient.chapter3;

public class Exercise9 {

    public static void main(String[] args) {
        Greeter johnsGreeter = new Greeter("John", 1000);
        Greeter janesGreeter = new Greeter("Jane", 1000);

        new Thread(johnsGreeter).start();
        new Thread(janesGreeter).start();
    }
}
