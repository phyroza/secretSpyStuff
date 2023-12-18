package com.tomslabs.exercises.javaImpatnient.chapter1;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise19 {
    public static void main(String[] args) {
        int[][] array = readIntsArray();
        printIntsArray(array);
        boolean magic = checkIfArrayIsMagic(array);

        System.out.println("magic = " + magic);
    }

    private static boolean checkIfArrayIsMagic(int[][] array) {
        int targetSum = Arrays.stream(array[0]).sum();
        return checkRowsForMagic(array, targetSum)
                && checkColsForMagic(array, targetSum)
                && checkDiagsForMagic(array, targetSum);
    }

    private static boolean checkDiagsForMagic(int[][] array, int targetSum) {
        int diagSum = 0;
        for (int i =0; i < array.length; i++)
        {
            diagSum += array[i][i];
        }
        if (diagSum != targetSum)
            return false;

        diagSum = 0;
        for (int i = 1; i <= array.length; i++) {
            diagSum += array[array.length - i][array.length - i];
        }
        if (diagSum != targetSum)
            return false;

        return true;
    }

    private static boolean checkColsForMagic(int[][] array, int targetSum) {
        for (int j = 0; j < array.length; j++) {

            int colSum = 0;
            for (int i = 0; i < array.length; i++) {
                colSum += array[i][j];
            }

            if (colSum != targetSum)
                return false;
        }

        return true;
    }

    private static boolean checkRowsForMagic(int[][] array, int targetVal) {
        for (int i = 0; i < array.length; i++) {
            if (Arrays.stream(array[i]).sum() != targetVal) {
               return false;
            }
        }

        return true;
    }

    private static void printIntsArray(int[][] array) {
        for (int[] ints : array) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    private static int[][] readIntsArray() {
        Scanner scanner = new Scanner(System.in);
        String currentLine = scanner.nextLine();
        int[][] array = null;
        int currentRow = 0;
        while(!currentLine.isEmpty()){
            String[] strNums = currentLine.split("\s");

            if (array == null)
                array = new int[strNums.length][strNums.length];

            for (int i = 0; i < strNums.length; i++) {
                array[currentRow][i] = Integer.parseInt(strNums[i]);
            }

            currentRow++;
            currentLine = scanner.nextLine();
        }
        return array;
    }
}
