package com.tomslabs.exercises.chapter3;

public interface Sequence<T> {
    public boolean hasNext();

    public T next();
}
