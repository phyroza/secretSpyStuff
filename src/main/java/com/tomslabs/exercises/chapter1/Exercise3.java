package com.tomslabs.exercises.javaImpatnient.chapter1;

import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();

        int max1 = findMaxWithIfs(x,y,z);
        int max2 = findMaxWithMathLib(x,y,z);

        System.out.println("max1 = " + max1);
        System.out.println("max2 = " + max2);
    }

    private static int findMaxWithMathLib(int x, int y, int z) {
        return Math.max(Math.max(x,y),z);
    }

    private static int findMaxWithIfs(int x, int y, int z) {
        int max = x;

        if (x > y) {
            if (x > z) {
                max = x;
            } else {
                max = z;
            }
        } else {
            if (y > z) {
                max = y;
            } else {
                max = z;
            }
        }

        return max;
    }
}
