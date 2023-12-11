package com.tomslabs.exercises.chapter9;

import java.io.IOException;
import java.io.Writer;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.file.StandardOpenOption.CREATE;

public class Exercise2 {
    private static void generateFileWordsToc(Path file) {
        try (Stream<String> lines = Files.lines(file, StandardCharsets.UTF_8);
             Writer writer = Files.newBufferedWriter(getOutputFilePath(file), StandardCharsets.UTF_8, CREATE)) {
            Pattern splitter = Pattern.compile("\\PL");
            var currentLine = new ArrayList<Integer>(1);
            currentLine.add(0);

            TreeMap<String, String> results = lines.peek(l -> {
                Integer lineNumber = currentLine.get(0);
                currentLine.clear();
                currentLine.add(lineNumber + 1);
            }).map(splitter::split).flatMap(Stream::of).map(String::new).filter(w -> !w.isEmpty()).collect(
                    Collectors.toMap(
                            s -> s,
                            s -> String.valueOf(currentLine.get(0)),
                            (i, j) -> String.join(", ", i, j),
                            TreeMap::new
                    )
            );

            for (Map.Entry<String, String> wordEntry : results.entrySet()) {
                writer.write(String.format("\"%s\" - %s\n", wordEntry.getKey(), wordEntry.getValue()));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Path getOutputFilePath(Path file) {
        String outputFileName = file.getFileName().toString().replaceFirst("\\..*", ".toc");
        Path outputFilePath = Paths.get(file.getParent().toString(), outputFileName);
        return outputFilePath;
    }

    public static void main(String[] args) throws URISyntaxException {
        URL inputFile = Exercise1.class.getResource("/text/wordsFile.txt");
        generateFileWordsToc(Paths.get(inputFile.toURI()));
    }
}
