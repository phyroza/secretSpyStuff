package com.tomslabs.exercises.chapter1;

import java.util.ArrayList;
import java.util.Random;

public class Exercise18 {

    public static final int POOL_CAPACITY = 49;
    public static final int NUMBER_OF_SELECTIONS = 6;

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(POOL_CAPACITY);
        for (int i = 0; i < POOL_CAPACITY; i++) {
            nums.add(i, i);
        }

        Random random = new Random();
        for (int i = 0; i < NUMBER_OF_SELECTIONS; i++)
        {
            int chosenIndex = random.nextInt(0, nums.size());
            Integer chosenValue = nums.remove(chosenIndex);
            System.out.println("Value #" + i + ": " + chosenValue);

        }
    }
}
