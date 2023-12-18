package com.tomslabs.exercises.javaImpatnient.chapter3;

import java.util.Arrays;
import java.util.Comparator;

public class Exercise15 {
    static Employee[] employees = {
            new Employee("John", 5000.0),
            new Employee("Steven", 5000.0),
            new Employee("Mary", 18332.5),
            new Employee("Sophia", 17332.5),
            new Employee("Stacy", 7332.5),
            new Employee("Jane", 7332.5),
            new Employee("Alice", 7332.5),
    };

    public static void main(String[] args) {
        Arrays.sort(employees, Comparator.comparing(Employee::getMeasure).thenComparing(Employee::getName));
        System.out.println("employees = " + Arrays.toString(employees));
        Arrays.sort(employees, Comparator.comparing(Employee::getMeasure).reversed().thenComparing(Employee::getName));
        System.out.println("employees = " + Arrays.toString(employees));
    }
}
