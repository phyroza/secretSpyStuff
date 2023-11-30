package com.tomslabs.exercises.chapter4;

public class Line extends Shape implements Cloneable {
    private final Point from;
    private final Point to;

    public Line(Point from, Point to) {
        super(getLineCenter(from, to));
        this.from = from;
        this.to = to;
    }

    private static Point getLineCenter(Point from, Point to) {
        return new Point((from.x + to.x) / 2, (from.y + to.y) / 2);
    }

    @Override
    public void moveBy(double dx, double dy) {
        from.x += dx;
        from.y += dy;
        to.x += dx;
        to.y += dy;
        center = getLineCenter(from, to);
    }

    @Override
    protected Line clone() throws CloneNotSupportedException {
        return new Line(new Point(from.x, from.y), new Point(to.x, to.y));
    }
}
