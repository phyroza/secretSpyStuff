package com.tomslabs.exercises.javaImpatnient.chapter2;

import org.omg.CORBA.IntHolder;

public class Exercise4 {
    public static void main(String[] args) {
        // ad.1 ponieważ typy proste są kopiowane przy przekazaniu i metoda otrzymuje kopie wartosci.
        IntHolder i1 = new IntHolder(3);
        IntHolder i2 = new IntHolder(5);

        System.out.println("i1 = " + i1.value);
        System.out.println("i2 = " + i2.value);
        swapInts(i1, i2);
        System.out.println("i1 = " + i1.value);
        System.out.println("i2 = " + i2.value);

        // ad. integer nope, they dont hold values.
    }

    public static void swapInts(IntHolder i1, IntHolder i2) {
        int temp = i1.value;
        i1.value = i2.value;
        i2.value = temp;
    }
}
