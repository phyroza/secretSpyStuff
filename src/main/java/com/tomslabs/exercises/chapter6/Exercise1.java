package com.tomslabs.exercises.chapter6;

import java.util.ArrayList;

public class Exercise1 {

    private static class Stack<E> {
        ArrayList<E> elements = new ArrayList<>();

        void push(E newElement) {
            elements.add(newElement);
        }

        E pop() {
            return elements.remove(elements.size() - 1);
        }

        boolean isEmpty() {
            return elements.isEmpty();
        }

        @Override
        public String toString() {
            return elements.toString();
        }
    }

    public static void main(String[] args) {
        Stack<String> stringStack = new Stack<>();
        stringStack.push("a");
        stringStack.push("b");
        stringStack.push("c");
        System.out.println("stringStack = " + stringStack);
        stringStack.pop();
        System.out.println("stringStack = " + stringStack);
    }
}
