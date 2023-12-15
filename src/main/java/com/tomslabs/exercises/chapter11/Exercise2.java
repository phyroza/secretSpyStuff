package com.tomslabs.exercises.chapter11;

import com.tomslabs.exercises.chapter11.Serializable.SerializationFormat;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Exercise2 {
    public static void main(String[] args) throws IOException {
        SerializeMe object = new SerializeMe();
        AnnotatedObjectOutputStream output = new AnnotatedObjectOutputStream(new FileOutputStream("objectsFile"), SerializationFormat.TEXT);

        output.writeObject(object);

        AnnotatedObjectInputStream input = new AnnotatedObjectInputStream(new FileInputStream("objectsFile"), SerializationFormat.TEXT);
        SerializeMe readObject = (SerializeMe) input.readObject();

        System.out.println(object.equals(readObject));
    }
}
