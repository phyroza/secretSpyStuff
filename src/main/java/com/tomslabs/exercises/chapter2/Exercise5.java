package com.tomslabs.exercises.chapter2;

public class Exercise5 {
    /**
     * Class for representing Point on 2d plane
     *
     * @param x position on X axis
     * @param y position on Y axis
     */
    private record Point(double x, double y) {
        /**
         * move point around
         * @param x x offset
         * @param y y offset
         * @return
         */
        Point translate(double x, double y) {
            return new Point(x() + x, y() + y);
        }

        /**
         * Scales the point
         * @param factor scaling facotr
         * @return new scaled point
         */
        Point scale(double factor) {
            return new Point(x() * factor, y() * factor);
        }
    }

    public static void main(String[] args) {
        Point scaledAndTranslated = new Point(3, 4).translate(1, 3).scale(0.5);
        System.out.println("scaledAndTranslated = " + scaledAndTranslated);
    }
}
