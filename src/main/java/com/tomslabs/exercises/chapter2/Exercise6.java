package com.tomslabs.exercises.chapter2;

public class Exercise6 {
    private static class Point {
        double x;
        double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        Point translate(double x, double y) {
            this.x += x;
            this.y += y;

            return this;
        }

        Point scale(double factor) {
            this.x *= factor;
            this.y *= factor;

            return this;
        }

        @Override
        public String toString() {
            return "Point[" + x + ", " + y + "]";
        }
    }

    public static void main(String[] args) {
        Point thePoint = new Point(3, 4).translate(1, 3).scale(0.5);
        System.out.println("thePoint = " + thePoint);
    }
}
