package com.tomslabs.exercises.chapter8;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Exercise5 {
    public static Stream<String> codePoints(String s) {
        return s.codePoints().mapToObj(cp -> new String(new int[]{cp}, 0, 1));
    }

    public static Stream<String> codePoints2(String s) {
        return IntStream.range(1, s.length() - 1).mapToObj(i -> s.substring(s.offsetByCodePoints(0, i - 1), s.offsetByCodePoints(0, i)));
    }

    public static void main(String[] args) {
        String string = "lol\uD835\uDD46lol\ud835\udd46lol";
        System.out.println(string);

//        System.out.println(string.substring(0, 4));
//        System.out.println(string.substring(0, string.offsetByCodePoints(0,4)));

        codePoints2(string).forEach(s -> System.out.println(s));
    }
}
