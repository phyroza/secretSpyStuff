package com.tomslabs.exercises.chapter8;

import com.tomslabs.exercises.chapter7.Exercise7;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.System.Logger.Level.ERROR;

public class Exercise1 {

    private static File wordsFile;

    private static System.Logger logger = System.getLogger(Exercise1.class.getName());

    private static final String[] words;

    static {
        try {
            wordsFile = new File(Exercise7.class.getResource("/text/wordsFile.txt").toURI());
            words = Files.readString(wordsFile.toPath(), StandardCharsets.UTF_8).split("\\PL+");
        } catch (URISyntaxException | IOException e) {
            logger.log(ERROR, "Could not locate or read wordsFile");
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        List<String> fiveLongWords = Stream.of(words).filter(s -> {
            if (s.length() > 12) {
                System.out.println(s);
                return true;
            }
            return false;
        }).limit(5).toList();
    }
}
