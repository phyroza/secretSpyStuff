package com.tomslabs.exercises.javaImpatnient.chapter7;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Stream;

import static java.lang.System.Logger.Level.ERROR;

public class Exercise8 {
    private static final System.Logger logger = System.getLogger(Exercise7.class.getName());
    private static final TreeMap<String, Set<Integer>> wordsMap = new TreeMap<>();

    public static void main(String[] args) {
        URL resource = Exercise7.class.getResource("/text/wordsFile.txt");
        if (resource != null) {

            try {
                List<String> lines = Files.readAllLines(new File(resource.toURI()).toPath());
                for (int lineNumber = 0; lineNumber < lines.size(); lineNumber++) {
                    String line = lines.get(lineNumber);
                    int finalLineNumber = lineNumber;
                    Stream.of(line.split(" ")).forEach(word -> {
                        wordsMap.putIfAbsent(word, new HashSet<>(Set.of(finalLineNumber)));
                        wordsMap.get(word).add(finalLineNumber);
                    });
                }

            } catch (IOException e) {
                logger.log(ERROR, "Could not open the file");
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }

        for (Map.Entry<String, Set<Integer>> entry : wordsMap.entrySet()) {
            System.out.println("entry = " + entry);
        }
    }
}
