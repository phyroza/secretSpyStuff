package com.tomslabs.exercises.chapter5;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.Logger.Level.ERROR;
import static java.lang.System.Logger.Level.WARNING;
import static java.text.MessageFormat.format;

public class Exercise1 {

    static private final System.Logger logger = System.getLogger("com.tomslabs.exercises.chapter5.exercise5");
    public static final String DATA_DIR = "C:\\training\\data\\";

    public static ArrayList<Double> readValues(String filename) throws IOException {
        ArrayList<Double> doubles = new ArrayList<>();
        try (Scanner scanner = new Scanner(Paths.get(filename), StandardCharsets.UTF_8)) {
            while (scanner.hasNext()) {
                try {
                    doubles.add(scanner.nextDouble());
                } catch (InputMismatchException e) {
                    String value = scanner.next();
                    logger.log(WARNING, format("Could not read one of the values: {0}", value), e);
                    throw e;
                }
            }
        } catch (IOException e) {
            logger.log(ERROR, "Could not open file for reading: {0}", filename);
            throw new IOException(e);
        }
        return doubles;
    }

    public static void main(String[] args) throws IOException {
        Thread.setDefaultUncaughtExceptionHandler((t, e) -> logger.log(ERROR, format("Uncaught exception: {0}", e)));

        Scanner scanner = new Scanner(System.in);
        String fileName = DATA_DIR + "doubleValues.txt";

        while (Files.exists(Paths.get(fileName))) {
            System.out.println(readValues(fileName));
            fileName = DATA_DIR + scanner.next();
        }
    }

}
