package com.tomslabs.exercises.chapter4;

public class Exercise7 {
    static Object add(Object first, Object second) {
        if (first instanceof Number firstNumber) {
            if (second instanceof Number secondNumber) {
                return firstNumber.doubleValue() + secondNumber.doubleValue();
            }
        }

        if (first instanceof Boolean firstBool) {
            if (second instanceof Boolean secondBool) {
                if (firstBool || secondBool) {
                    return Boolean.TRUE;
                }
            }
        }

        return first.toString() + second.toString();
    }

    public static void main(String[] args) {
        System.out.println(add(new Double("0.2"), new Long("12")));
        System.out.println(add(Boolean.TRUE, Boolean.FALSE));
        System.out.println(add("lol ", "zonk"));
    }
}
