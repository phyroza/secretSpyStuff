package com.tomslabs.exercises.chapter4;

public class Rectangle extends Shape implements Cloneable {
    private final Point topLeft;
    private double width;
    private double height;

    public Rectangle(Point topLeft, double width, double height) {
        super(getRectangleCenter(topLeft, width, height));
        this.topLeft = topLeft;
    }

    private static Point getRectangleCenter(Point topLeft, double width, double height) {
        return new Point((topLeft.x + width) / 2, (topLeft.y + height) / 2);
    }

    @Override
    public void moveBy(double dx, double dy) {
        topLeft.x += dx;
        topLeft.y += dy;
        center = getRectangleCenter(topLeft, width, height);
    }

    @Override
    protected Rectangle clone() throws CloneNotSupportedException {
        return new Rectangle(new Point(topLeft.x, topLeft.y), width, height);
    }
}
