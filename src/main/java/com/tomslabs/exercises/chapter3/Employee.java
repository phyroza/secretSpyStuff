package com.tomslabs.exercises.javaImpatnient.chapter3;

public class Employee implements Measurable {
    private final String name;
    private final double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public double getMeasure() {
        return salary;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s with salary %.2f", name, salary);
    }
}
