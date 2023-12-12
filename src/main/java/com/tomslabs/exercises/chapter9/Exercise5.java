package com.tomslabs.exercises.chapter9;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

public class Exercise5 {
    public static void main(String[] args) {
        SortedMap<String, Charset> availableCharsets = Charset.availableCharsets();
        Map<String, List<Charset>> charsetsForReplacement = new HashMap<>();
        for (Charset charset : availableCharsets.values()) {
            CharsetEncoder charsetEncoder = null;
            try {
                charsetEncoder = charset.newEncoder();
            } catch (UnsupportedOperationException e) {
                continue;
            }
            String replacementChar = new String(charsetEncoder.replacement(), charset);

            List<Charset> prevCharsets = charsetsForReplacement.putIfAbsent(replacementChar, new ArrayList<>(List.of(charset)));
            if (prevCharsets != null)
                charsetsForReplacement.compute(replacementChar, (k, v) -> {
                    v.add(charset);
                    return v;
                });
        }

        System.out.println(charsetsForReplacement);
    }
}
