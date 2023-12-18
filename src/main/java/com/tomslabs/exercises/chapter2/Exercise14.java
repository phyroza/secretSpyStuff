package com.tomslabs.exercises.javaImpatnient.chapter2;

import com.opencsv.CSVParser;

import java.io.IOException;
import java.util.Arrays;

public class Exercise14 {
    public static void main(String[] args) throws IOException {
        CSVParser csvParser = new CSVParser();
        String[] strings = csvParser.parseLine("lol,wut,meh");
        System.out.println("strings = " + Arrays.toString(strings));
    }
}
