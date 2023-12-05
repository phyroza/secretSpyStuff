package com.tomslabs.exercises.chapter7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Exercise12 {
    public static void main(String[] args) {
        ArrayList<String> sentences = getStrings();

        for (String sentence : sentences) {
            System.out.println(sentence);
            List<String> words = Arrays.asList(sentence.toLowerCase().replace(".", "").split(" "));

            Collections.shuffle(words.subList(0, words.size()));

            words.set(0, words.get(0).substring(0, 1).toUpperCase() + words.get(0).substring(1));
            words.set(words.size() - 1, words.get(words.size() - 1) + ".");
            System.out.println(String.join(" ", words));
        }
    }

    private static ArrayList<String> getStrings() {
        ArrayList<String> sentences = new ArrayList<>();
        sentences.add("Two more days and all his problems would be solved.");
        sentences.add("Malls are great places to shop; I can find everything I need under one roof.");
        sentences.add("The family’s excitement over going to Disneyland was crazier than she anticipated.");
        sentences.add("The tumbleweed refused to tumble but was more than willing to prance.");
        sentences.add("The fox in the tophat whispered into the ear of the rabbit.");
        sentences.add("If you don't like toenails, you probably shouldn't look at your feet.");
        return sentences;
    }
}
