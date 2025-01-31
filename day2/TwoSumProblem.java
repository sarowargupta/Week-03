package com.week3.day2;
import java.util.*;

public class TwoSumProblem {
    public static void findTwoSum(int[] nums, int target) {
        // Create a HashMap to store the number and its index
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Check if the complement is already in the map
            if (map.containsKey(complement)) {
                System.out.println("Indices of the two numbers: " + map.get(complement) + " and " + i);
                return;
            }

            // Add the current number and its index to the map
            map.put(nums[i], i);
        }

        // If no solution is found, return an empty array
        System.out.println("No solution found.");
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        // Call the method to find and print the result
        findTwoSum(nums, target);
    }
}
