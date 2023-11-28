package com.tomslabs.exercises.chapter3.Exercise1;

import com.tomslabs.exercises.chapter3.Employee;
import com.tomslabs.exercises.chapter3.Measurable;

public class Exercise1 {

    static double average(Measurable[] objects) {
        double sum = 0.0;
        for (Measurable object : objects) {
            sum += object.getMeasure();
        }
        return sum / objects.length;
    }

    public static void main(String[] args) {
        Measurable[] employees = {
                new Employee("John", 6000.0),
                new Employee("Steven", 5000.0),
                new Employee("Stacy", 7332.5),
                new Employee("Jane", 7332.5),
                new Employee("Mary", 18332.5),
                new Employee("Sophia", 17332.5),
        };
        System.out.printf("salaryAverage = %.2f", average(employees));
    }
}
