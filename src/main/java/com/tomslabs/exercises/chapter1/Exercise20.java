package com.tomslabs.exercises.chapter1;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int degree = scanner.nextInt();

        printPascalTriangle(getPascalTriangle(degree));
    }

    private static void printPascalTriangle(ArrayList<ArrayList<Integer>> triangle) {
        for (ArrayList<Integer> row : triangle) {
            for (Integer i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static ArrayList<ArrayList<Integer>> getPascalTriangle(int degree) {
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<>(degree);
        for (int i=0; i<degree;i++) {
            ArrayList<Integer> level = new ArrayList<>();
            if (i==0) {
                level.add(1);
                triangle.add(level);
                continue;
            }
            if (i==1){
                level.add(1);
                level.add(1);
                triangle.add(level);
                continue;
            }

            level.add(1);
            for (int j=1; j<i;j++){
                level.add(j, triangle.get(i-1).get(j-1) + triangle.get(i-1).get(j));
            }
            level.add(1);

            triangle.add(level);
        }

        return triangle;
    }
}
