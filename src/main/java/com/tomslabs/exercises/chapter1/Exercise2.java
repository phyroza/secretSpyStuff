package com.tomslabs.exercises.chapter1;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int angle = scanner.nextInt();

        System.out.println(normalizeByMod(angle));
        System.out.println(normalizeFloorMod(angle));
    }

    private static int normalizeFloorMod(int angle) {
        return Math.floorMod(angle, 360);
    }

    private static int normalizeByMod(int angle) {
        angle = angle % 360;
        if (angle < 0)
            angle = 360 + angle;
        return angle;
    }
}
