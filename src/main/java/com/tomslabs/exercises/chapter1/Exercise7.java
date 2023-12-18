package com.tomslabs.exercises.javaImpatnient.chapter1;

import java.util.Scanner;

public class Exercise7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String val1 = scanner.next();
        int int1 = Integer.parseUnsignedInt(val1);

        String val2 = scanner.next();
        int int2 = Integer.parseUnsignedInt(val2);

        System.out.println(int1 + int2);
        System.out.println(int1 - int2);
        System.out.println(Integer.divideUnsigned(int1, int2));
        System.out.println(int1*int2);
        System.out.println(Integer.remainderUnsigned(int1, int2));
    }
}
