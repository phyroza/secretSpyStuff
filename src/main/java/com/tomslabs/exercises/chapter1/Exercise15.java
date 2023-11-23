package com.tomslabs.exercises.chapter1;

import java.util.Scanner;

public class Exercise15 {
    public static void main(String[] args) {
        String desiredLevel = new Scanner(System.in).next();

        switch(desiredLevel){
            case "level5" :
                System.out.println("Getting you skills from level 5");
            case "level4" :
                System.out.println("Getting you skills from level 4");
            case "level3" :
                System.out.println("Getting you skills from level 3");
            case "level2" :
                System.out.println("Getting you skills from level 2");
            case "level1" :
                System.out.println("Getting you skills from level 1");
        }

    }
}
