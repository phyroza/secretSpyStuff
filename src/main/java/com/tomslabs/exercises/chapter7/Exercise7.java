package com.tomslabs.exercises.chapter7;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import static java.lang.System.Logger.Level.ERROR;

public class Exercise7 {

    static TreeMap<String, Integer> wordsMap = new TreeMap<>();
    private static final System.Logger logger = System.getLogger(Exercise7.class.getName());

    public static void main(String[] args) {
        URL resource = Exercise7.class.getResource("/text/wordsFile.txt");
        if (resource != null) {
            try (Scanner scanner = new Scanner(resource.openStream(), StandardCharsets.UTF_8)) {
                while (scanner.hasNext()) {
                    String word = scanner.next();
                    Integer previousValue = wordsMap.putIfAbsent(word, 1);
                    if (previousValue != null) {
                        wordsMap.computeIfPresent(word, (s, v) -> v + 1);
                    }
                }
            } catch (IOException e) {
                logger.log(ERROR, "Could not open the file");
            }


            List<Map.Entry<String, Integer>> list = wordsMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).toList();
            for (Map.Entry<String, Integer> entry : list) {
                System.out.println(entry);
            }
        }
    }
}
