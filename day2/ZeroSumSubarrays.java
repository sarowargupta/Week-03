package com.week3.day2;
import java.util.*;

public class ZeroSumSubarrays {
    //method tp find subarrays with a sum of zero
    public static void findZeroSumSubarrays(int[] arr) {
       HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // If sum is zero, print from 0 to i
            if (sum == 0) {
                System.out.println("Subarray found from index 0 to " + i);
                printSubarray(arr, 0, i);
            }

            // If sum has been seen before, subarray exists
            if (map.containsKey(sum)) {
                System.out.println("Subarray found from index " + (map.get(sum) + 1) + " to " + i);
                printSubarray(arr, map.get(sum) + 1, i);
            }

            // Store the sum with the latest index
            map.put(sum, i);

        }

    }
        //Helper method to print subarray
        private static void printSubarray(int[] arr, int start, int end) {
            System.out.println(Arrays.toString(Arrays.copyOfRange(arr, start, end + 1)));
        }

    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 3, 1, 3,4 ,1, -5, -2, -2};
        //call the method to find subarrays whose sum in 0
        findZeroSumSubarrays(arr);
    }
}
