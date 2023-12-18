package com.tomslabs.exercises.javaImpatnient.chapter4;

class LabeledPoint extends Point {
    private String label;

    public LabeledPoint(String label, double x, double y) {
        super(x, y);
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof LabeledPoint labeledPoint) {
            return super.equals(obj) && this.label.equals(labeledPoint.getLabel());
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return this.label + " " + String.format("(%.2f,%.2f)", this.x, this.y);
    }

    public void letsDoPointyThings(Point point) {
        double sum = point.x + point.y; //wut
    }

    public void letsDoPointyThings(LabeledPoint labeledPoint) {
        double sum = labeledPoint.x + labeledPoint.y;
    }

    public static void main(String[] args) {
        Point p1 = new Point(2.2, 3.3);
        System.out.println(p1.x);
        LabeledPoint p2 = new LabeledPoint("lalalala", 2.2, 3.3);
        System.out.println(p2.x);
    }
}
