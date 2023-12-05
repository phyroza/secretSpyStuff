package com.tomslabs.exercises.chapter7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Exercise11 {
    public static void main(String[] args) {
        ArrayList<String> sentences = new ArrayList<>();
        sentences.add("Two more days and all his problems would be solved.");
        sentences.add("Malls are great places to shop; I can find everything I need under one roof.");
        sentences.add("The family’s excitement over going to Disneyland was crazier than she anticipated.");
        sentences.add("The tumbleweed refused to tumble but was more than willing to prance.");
        sentences.add("The fox in the tophat whispered into the ear of the rabbit.");
        sentences.add("If you don't like toenails, you probably shouldn't look at your feet.");

        for (String sentence : sentences) {
            List<String> words = Arrays.asList(sentence.split(" "));
            System.out.println(String.join(" ", words));
            Collections.shuffle(words.subList(1, words.size() - 1));
            System.out.println(String.join(" ", words));
        }
    }
}
