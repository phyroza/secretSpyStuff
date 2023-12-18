package com.tomslabs.exercises.javaImpatnient.chapter8;

import com.tomslabs.exercises.javaImpatnient.chapter7.Exercise7;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.stream.Stream;

import static java.lang.System.Logger.Level.ERROR;

public class Exercise2 {
    private static System.Logger logger = System.getLogger(Exercise1.class.getName());

    private static final String[] words;

    static {
        try {
            File wordsFile = new File(Exercise7.class.getResource("/text/wordsFile.txt").toURI());
            words = Files.readString(wordsFile.toPath(), StandardCharsets.UTF_8).split("\\PL+");
        } catch (URISyntaxException | IOException e) {
            logger.log(ERROR, "Could not locate or read wordsFile");
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        long seqStart = System.currentTimeMillis();
        long longWordCount = Stream.of(words).filter(s -> s.length() > 12).count();
        long seqEnd = System.currentTimeMillis();
        System.out.printf("Sequential,  %d  hits in: %d millis\n", longWordCount, (seqEnd - seqStart));


        long parrarelStart = System.currentTimeMillis();
        long longWordCountParrarel = Stream.of(words).filter(s -> s.length() > 12).count();
        long parallelEnd = System.currentTimeMillis();
        System.out.printf("Parallel,  %d  hits in: %d millis\n", longWordCountParrarel, (parallelEnd - parrarelStart));
    }
}
