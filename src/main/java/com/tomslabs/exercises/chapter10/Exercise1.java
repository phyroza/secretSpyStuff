package com.tomslabs.exercises.chapter10;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercise1 {
    public static void main(String[] args) throws IOException {
        List<Path> wordContainingFile = checkDirForWord(Paths.get("C:\\training\\javaimpatient"), "int");
        System.out.println("Found (" + wordContainingFile.size() + ") files containing word " + "int" + ": " + wordContainingFile);
    }

    private static List<Path> checkDirForWord(Path startPath, String word) {
        final String wordLowerCase = word.toLowerCase();
        List<Path> results = null;

        if (Files.isDirectory(startPath)) {
            try (Stream<Path> fileDirlist = Files.list(startPath)) {
                results = fileDirlist.parallel().map(path -> checkDirForWord(path, wordLowerCase)
                ).filter(l -> l != null && !l.isEmpty()).flatMap(Collection::stream).collect(Collectors.toList());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            if (fileContainsString(startPath, wordLowerCase))
                results = List.of(startPath);
        }
        return results;
    }

    private static boolean fileContainsString(Path path, String word) {
//        System.out.println("Checking path: " + path);
        try (Stream<String> lines = Files.lines(path)) {
            return lines.anyMatch(l -> l.toLowerCase().contains(word));
        } catch (IOException | UncheckedIOException e) {
//            System.out.println("Exception checking path: " + path);
            return false;
        }
    }
}
