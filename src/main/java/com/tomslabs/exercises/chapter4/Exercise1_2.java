package com.tomslabs.exercises.chapter4;

public class Exercise1_2 {
    private static class Point {
        private double x;
        private double y;

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

    private static class LabeledPoint extends Point {
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
            return this.label + " " + super.toString();
        }
    }
}
