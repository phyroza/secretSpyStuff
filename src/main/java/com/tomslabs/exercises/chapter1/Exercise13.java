package com.tomslabs.exercises.javaImpatnient.chapter1;

import java.util.Scanner;

public class Exercise13 {
    enum DIRECTION { N, S, E, W }
    static int x = 0;
    static int y = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            String direction = scanner.next();

            int[] ints = switch (DIRECTION.valueOf(direction)) {
                case E -> new int[]{0, 1};
                case W -> new int[]{0, -1};
                case N -> new int[]{1, 0};
                case S -> new int[]{-1, 0};
            };

            x+=ints[0];
            y+=ints[1];
            System.out.println("current position = {" + x + ", " + y + "}");
        }
    }
}
