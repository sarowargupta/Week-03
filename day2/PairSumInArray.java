package com.week3.day2;
import java.util.*;

public class PairSumInArray {
        // Method to check if a pair with the given sum exists
        public static void hasPairWithSum(int[] arr, int target) {
            // Create a HashMap to store the number and its index
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < arr.length; i++) {
                int complement = target - arr[i];

                // Check if the complement exists in the map
                if (map.containsKey(complement)) {
                    System.out.println("Pair found: (" + arr[i] + ", " + complement + ")");
                    return;
                }

                // Store the current number in the map
                map.put(arr[i], i);

            }
            //if no pair found
            System.out.println("No pair found with sum " + target);

        }

        public static void main(String[] args) {
            int[] arr = {10, 15, 3, 7};
            int target = 17;
            // Call the method to find and print the result
            hasPairWithSum(arr, target);
        }


}
