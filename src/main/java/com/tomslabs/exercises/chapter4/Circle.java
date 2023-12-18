package com.tomslabs.exercises.javaImpatnient.chapter4;

public class Circle extends Shape implements Cloneable {
    private double radius;

    public Circle(Point center, double radius) {
        super(center);
        this.radius = radius;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Circle(new Point(center.x, center.y), radius);

    }
}
