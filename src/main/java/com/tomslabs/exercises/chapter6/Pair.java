package com.tomslabs.exercises.javaImpatnient.chapter6;

class Pair<E extends Comparable<? super E>> {
    E first;
    E second;

    public Pair(E first, E second) {
        this.first = first;
        this.second = second;
    }

    public E getFirst() {
        return first;
    }

    public void setFirst(E first) {
        this.first = first;
    }

    public E getSecond() {
        return second;
    }

    public void setSecond(E second) {
        this.second = second;
    }

    E getMax() {
        return first.compareTo(second) < 0 ? first : second;
    }

    E getMin() {
        return first.compareTo(second) >= 0 ? first : second;
    }

    @Override
    public String toString() {
        return first.toString() + " " + second.toString();
    }
}
