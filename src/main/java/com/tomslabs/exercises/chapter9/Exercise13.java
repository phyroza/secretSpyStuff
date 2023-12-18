package com.tomslabs.exercises.javaImpatnient.chapter9;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Exercise13 {
    private static class Smth implements Serializable {
        String name;
        int furyFactor = 0;
        transient String soul;

        public Smth(String name, int furyFactor, String soulElement) {
            this.name = name;
            this.furyFactor = furyFactor;
            soul = soulElement;
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Smth a = new Smth("MyLife", Integer.MAX_VALUE, "joyful");

        Smth clonedObject = cloneBySerialize(a);

        System.out.println(a);
        System.out.println(clonedObject);
    }

    private static Smth cloneBySerialize(Smth a) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream objectBuffer = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(objectBuffer);
        oos.writeObject(a);

        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(objectBuffer.toByteArray()));
        Smth readObject = (Smth) ois.readObject();

        return readObject;
    }
}
