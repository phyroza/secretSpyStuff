package com.tomslabs.exercises.chapter6;

import java.util.Arrays;
import java.util.function.IntFunction;

import static java.lang.reflect.Array.newInstance;

public class Exercise2 {

    public static void main(String[] args) {
        StackA<String> stackA = new StackA<>(String[]::new);
        System.out.println("stackA.isEmpty() = " + stackA.isEmpty());
        stackA.push("a");
        stackA.push("b");
        stackA.push("c");
        stackA.push("d");
        stackA.push("e");
        stackA.push("f");
        System.out.println("stackA.isEmpty() = " + stackA.isEmpty());
        System.out.println("stackA = " + stackA);
        String lastPopped = stackA.pop();
        System.out.println("lastPopped = " + lastPopped);
        System.out.println("stackA = " + stackA);

        StackB<String> stackB = new StackB<>(String.class);
        System.out.println("stackB.isEmpty() = " + stackB.isEmpty());
        stackB.push("aaaa");
        stackB.push("bbbb");
        stackB.push("cccc");
        stackB.push("dddd");
        System.out.println("stackB.isEmpty() = " + stackB.isEmpty());
        System.out.println("stackB = " + stackB);
        String pop = stackB.pop();
        System.out.println("stackB = " + stackB);

    }

    private static class StackB<E> {
        private static final int REALLOC_EXTRA_SIZE = 5;
        Object[] elements;
        private final Class<E> elementClass;
        private int lastIndex = 0;

        public StackB(Class<E> elementClass) {
            this.elementClass = elementClass;
            elements = (Object[]) newInstance(elementClass, REALLOC_EXTRA_SIZE);
        }

        E pop() {
            if (lastIndex == 0)
                throw new IllegalStateException("No elements present");

            @SuppressWarnings("unchecked")
            E element = (E) elements[lastIndex - 1];
            elements[lastIndex - 1] = null;
            lastIndex--;
            return element;
        }

        void push(E newElement) {
            checkAndResize();
            elements[lastIndex++] = newElement;
        }

        private void checkAndResize() {
            if (lastIndex >= elements.length) {
                Object[] newArray = (Object[]) newInstance(elementClass, elements.length + REALLOC_EXTRA_SIZE);
                System.arraycopy(elements, 0, newArray, 0, elements.length);
                elements = newArray;
            }
        }

        @Override
        public String toString() {
            return Arrays.toString(elements);
        }

        boolean isEmpty() {
            return lastIndex == 0;
        }
    }

    private static class StackA<E> {
        public static final int REALLOC_EXTRA_SIZE = 3;
        E[] elements;
        IntFunction<E[]> constructor;
        int lastIndex = 0;

        public StackA(IntFunction<E[]> constructor, int initSize) {
            this.constructor = constructor;
            elements = this.constructor.apply(initSize);
        }

        public StackA(IntFunction<E[]> constructor) {
            this(constructor, REALLOC_EXTRA_SIZE);
        }

        void push(E newElement) {
            checkAndResize();
            elements[lastIndex++] = newElement;
        }

        E pop() {
            if (lastIndex == 0)
                throw new IllegalStateException("No elements present");

            E element = elements[lastIndex - 1];
            elements[lastIndex - 1] = null;
            lastIndex--;
            return element;
        }

        boolean isEmpty() {
            return lastIndex == 0;
        }

        private void checkAndResize() {
            if (lastIndex >= elements.length) {
                E[] newArray = constructor.apply(elements.length + REALLOC_EXTRA_SIZE);
                System.arraycopy(elements, 0, newArray, 0, elements.length);
                elements = newArray;
            }
        }

        @Override
        public String toString() {
            return Arrays.toString(elements);
        }
    }
}
