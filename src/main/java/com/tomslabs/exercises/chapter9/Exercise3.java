package com.tomslabs.exercises.chapter9;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.MalformedInputException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

import static java.nio.charset.StandardCharsets.*;

public class Exercise3 {

    private static List<Charset> charsets = List.of(US_ASCII, UTF_8, UTF_16, ISO_8859_1);
    private static final List<String> englishWords;
    private static Pattern separatorSplitter = Pattern.compile("\\PL+");

    static {
        try {
            englishWords = Arrays.asList(Files.readString(getResourcePath("englishWords.txt"), UTF_8).split("\\PL+"));
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws URISyntaxException {
        String[] unknownEncodingFileNames = {"sampleFileASCII.txt", "sampleFileISO88591.txt", "sampleFileUTF8.txt", "sampleFileUTF16.txt"};
        for (String unknownEncodingFileName : unknownEncodingFileNames) {
            Charset guessedEncoding = guessEncoding(getResourcePath(unknownEncodingFileName));
            System.out.printf("Done guessing encoding for file: %s, methinks its %s%n", unknownEncodingFileName, guessedEncoding.name());
        }
    }

    private static Path getResourcePath(String unknownEncodingFileName) throws URISyntaxException {
        return Paths.get(new File(Exercise3.class.getResource("/text/" + unknownEncodingFileName).toURI()).getAbsolutePath());
    }

    private static Charset guessEncoding(Path unknownEncodingFileName) {
        System.out.printf("Guessing %s%n", unknownEncodingFileName);
        HashMap<Charset, Long> hitMap = new HashMap<>();
        for (Charset charset : charsets) {
            try {
                String content = Files.readString(unknownEncodingFileName, charset);
                long matchedWords = Arrays.stream(separatorSplitter.split(content)).filter(englishWords::contains).count();
                hitMap.put(charset, matchedWords);
                System.out.println(charset.name() + " " + matchedWords);
            } catch (MalformedInputException e) {
                System.out.println(charset.name() + " - malformed input :(");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("hitMap = " + hitMap);

        Optional<Map.Entry<Charset, Long>> maxEntry = hitMap.entrySet().stream().max(new Comparator<>() {
            @Override
            public int compare(Map.Entry<Charset, Long> o1, Map.Entry<Charset, Long> o2) {
                return (int) (o1.getValue() - o2.getValue());
            }
        });

        return maxEntry.orElseThrow().getKey();
    }
}
