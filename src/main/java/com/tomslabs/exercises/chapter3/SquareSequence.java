package com.tomslabs.exercises.javaImpatnient.chapter3;

import java.math.BigInteger;

public class SquareSequence implements Sequence<BigInteger> {
    private static final BigInteger one = new BigInteger("1");
    private BigInteger currentInt = new BigInteger("0");

    public boolean hasNext() {
        return true;
    }

    public BigInteger next() {
        currentInt = currentInt.add(one);
        return currentInt.multiply(currentInt);
    }
}