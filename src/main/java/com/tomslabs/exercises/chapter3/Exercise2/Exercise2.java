package com.tomslabs.exercises.chapter3.Exercise2;

import com.tomslabs.exercises.chapter3.Employee;
import com.tomslabs.exercises.chapter3.Measurable;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class Exercise2 {

    static Measurable largest(Measurable[] objects) {
        Arrays.sort(objects, Comparator.comparing(Measurable::getMeasure).reversed());
        return objects.length > 0 ? objects[0] : null;
    }

    public static void main(String[] args) {
        Measurable[] employees = {
                new Employee("John", 6000.0),
                new Employee("Steven", 5000.0),
                new Employee("Mary", 18332.5),
                new Employee("Sophia", 17332.5),
                new Employee("Stacy", 7332.5),
                new Employee("Jane", 7332.5),
        };

        Measurable highestSalaryEmp = largest(employees);
        System.out.println("highestSalaryEmp = " + highestSalaryEmp);
    }
}
