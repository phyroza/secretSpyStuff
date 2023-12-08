package com.tomslabs.exercises.chapter8;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Map;
import java.util.stream.Stream;

import static java.lang.System.Logger.Level.ERROR;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Exercise7 {
    private static System.Logger logger = System.getLogger(Exercise7.class.getName());

    private static final String[] words;

    static {
        try {
            File wordsFile = new File(com.tomslabs.exercises.chapter7.Exercise7.class.getResource("/text/wordsFile.txt").toURI());
            words = Files.readString(wordsFile.toPath(), StandardCharsets.UTF_8).split("\\PL+");
        } catch (URISyntaxException | IOException e) {
            logger.log(ERROR, "Could not locate or read wordsFile");
            throw new RuntimeException(e);
        }
    }

    static boolean lettersOnly(String s) {
        return s.codePoints().filter(i -> !Character.isAlphabetic(i)).findAny().isEmpty();
    }

    public static void main(String[] args) {
        Stream.of(words).filter(Exercise7::lettersOnly).limit(100).forEach(System.out::println);

        Map<String, Long> wordsCounts = Stream.of(words)
                .map(String::toLowerCase)
                .collect(groupingBy(String::toString, counting()));

        wordsCounts.entrySet().stream().sorted((o1, o2) -> (int) (o2.getValue() - o1.getValue()))
                .limit(10)
                .forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));
    }
}
