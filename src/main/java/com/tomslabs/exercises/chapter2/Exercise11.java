package com.tomslabs.exercises.chapter2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Exercise11 {
    private static class RandomNumbers {

        private static final Random random = new Random();

        static int randomElement(int[] nums) {
            return nums[random.nextInt(0, nums.length)];
        }

        static int randomElement(ArrayList<Integer> nums) {
            return nums.get(random.nextInt(0, nums.size()));
        }
    }

    public static void main(String[] args) {
        int[] intsArray = new Random().ints(100, 0, 1000).toArray();
        int randomInt = RandomNumbers.randomElement(intsArray);
        System.out.println("randomInt = " + randomInt);

        List<Integer> intsList = new Random().ints(100, 0, 1000).boxed().toList();
        randomInt = RandomNumbers.randomElement(new ArrayList<>(intsList));
        System.out.println("randomInt = " + randomInt);
    }
}
