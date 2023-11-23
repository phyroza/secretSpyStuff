package com.tomslabs.exercises.chapter1;

import java.math.BigInteger;
import java.util.Scanner;

public class Exercise6 {

    public static final BigInteger BIG_INT_1 = new BigInteger("1");

    private static BigInteger factorial(BigInteger n){
        if (n.equals(BIG_INT_1))
            return BIG_INT_1;
        else
            return n.multiply(factorial(n.subtract(BIG_INT_1)));
    }

    public static void main(String[] args) {
        String number = new Scanner(System.in).next();
        System.out.println(factorial(new BigInteger(number)));
    }
}
