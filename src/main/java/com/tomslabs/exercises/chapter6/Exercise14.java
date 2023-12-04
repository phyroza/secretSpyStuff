package com.tomslabs.exercises.chapter6;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;

public class Exercise14 {
    public static <T extends Closeable> void closeAll(ArrayList<T> elements) {
        RuntimeException runtimeException = new RuntimeException("Error while closing one or more elements");
        try {
            for (T element : elements) {
                element.close();
            }
        } catch (IOException e) {
            runtimeException.addSuppressed(e);
        } finally {
            if (runtimeException.getSuppressed().length > 0)
                throw runtimeException;
        }
    }
}
