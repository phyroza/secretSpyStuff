package com.tomslabs.exercises.chapter1;

import java.util.Scanner;

public class Exercise12 {
    enum DIRECTION { N, S, E, W };

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

            System.out.println("ints = {" + ints[0] + ", " + ints[1] + "}");
        }
    }
}
