package com.tomslabs.exercises.chapter2;

public class Exercise5 {
    private record Point(double x, double y) {
        Point translate(double x, double y) {
            return new Point(x() + x, y() + y);
        }

        Point scale(double factor) {
            return new Point(x() * factor, y() * factor);
        }
    }

    public static void main(String[] args) {
        Point scaledAndTranslated = new Point(3, 4).translate(1, 3).scale(0.5);
        System.out.println("scaledAndTranslated = " + scaledAndTranslated);
    }
}
