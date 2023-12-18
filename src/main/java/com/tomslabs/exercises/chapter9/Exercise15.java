package com.tomslabs.exercises.javaImpatnient.chapter9;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

public class Exercise15 {

    public static final String POINTS_FILE = "pointsFile";

    private static class Point implements Serializable {
        int coords[] = new int[2];

        //        int x,y;
        private static final long serialVersionUID = 2L;

        public Point(int x, int y) {
            this.coords[0] = x;
            this.coords[1] = y;
        }

        @Override
        public String toString() {
            return String.format("[%d,%d]", coords[0], coords[1]);
//            return String.format("[%d,%d]", x, y);
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Point[] points = new Point[10];
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point(i, 9 - i);
        }

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(POINTS_FILE));
        oos.writeObject(points);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(POINTS_FILE));
        Point[] readPoints = (Point[]) ois.readObject();

        System.out.println(List.of(readPoints));

        // field was not deserialized and left with initial value
        // local class incompatible: stream classdesc serialVersionUID = 1, local class serialVersionUID = 2
    }
}
