package com.tomslabs.exercises.chapter4;

public class Point {
    protected double x;
    protected double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(x) + Double.hashCode(y);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Point point) {
            return this.x == point.x && this.y == point.y;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return String.format("(%.2f,%.2f)", this.x, this.y);
    }
}
