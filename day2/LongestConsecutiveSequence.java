package com.week3.day2;
import java.util.*;

public class LongestConsecutiveSequence {
    // Method to find the length of the longest length consecutive sequence
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // Create a HashMap to store the number and boolean value
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, true);
        }

        int length = 0;

        for (int num : nums) {
            // If the previous number doesn't exist, this is the start of a sequence
            if (!map.containsKey(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (map.containsKey(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                length = Math.max(length, currentStreak);
            }
        }

        return length;
    }


    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};

        // Call the method  and print the result
        System.out.println("Longest consecutive sequence length: " + longestConsecutive(nums));
    }
}

