package com.tomslabs.exercises.chapter4;

public abstract class Shape {
    protected Point center;

    public Shape(Point center) {
        this.center = center;
    }

    public void moveBy(double dx, double dy) {
        center.x += dx;
        center.y += dy;
    }

    public Point getCenter() {
        return new Point(center.x, center.y);
    }
}
