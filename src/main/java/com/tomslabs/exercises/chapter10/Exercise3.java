package com.tomslabs.exercises.javaImpatnient.chapter10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class Exercise3 {

    public static final long TIMEOUT = 5_000L;

    public static void main(String[] args) {
        Path dirPath = Paths.get("C:\\training\\javaimpatient");
        String wordToFind = "Don't call my name Alejandro";

        ArrayList<Callable<String>> tasks = new ArrayList<>();
        try (Stream<Path> dirContents = Files.list(dirPath)) {
            dirContents.filter(Files::isRegularFile).forEach((file) -> {
                tasks.add(findWordInFile(file, wordToFind));
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ExecutorService executorService = Executors.newCachedThreadPool();
        try {
            executorService.invokeAny(tasks);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    private static Callable<String> findWordInFile(Path path, String word) {

        return () -> {
            try (Stream<String> lines = Files.lines(path)) {
                Optional<String> result = lines
                        .takeWhile(l -> !Thread.currentThread().isInterrupted())
                        .filter(l -> l.toLowerCase().contains(word.toLowerCase()))
                        .findFirst();

                if (result.isPresent()) {
                    String resultValue = result.get() + " " + path;
                    System.out.println(">>>> FOUND id: " + Thread.currentThread().getId() + " on path " + path + " : \t" + resultValue);
                    return resultValue;
                } else {
                    System.out.println("id: " + Thread.currentThread().getId() + " Did not find word in my file: " + path);
                    Thread.sleep(TIMEOUT);
                    System.out.println("Time out guys :(");
                    return "";
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                System.out.println("id: " + Thread.currentThread().getId() + "- Someone else found it or time's out, bye bye");
                return "";
            }
        };
    }
}
