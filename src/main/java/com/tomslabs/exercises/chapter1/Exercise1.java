package com.tomslabs.exercises.chapter1;

import java.util.Scanner;

public class Exercise1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int decimalInt = sc.nextInt();
        System.out.println(Integer.toBinaryString(decimalInt));
        System.out.printf("%o\n", decimalInt);
        System.out.printf("%x\n", decimalInt);
        System.out.printf("%a", 1.0 / decimalInt);
    }
}
