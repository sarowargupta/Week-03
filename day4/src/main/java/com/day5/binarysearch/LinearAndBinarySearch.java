package com.day5.binarysearch;
import java.util.Arrays;

public class LinearAndBinarySearch {

        // Function to find the first missing positive integer using Linear Search
        public static int findFirstMissingPositive(int[] arr) {
            int n = arr.length;

            // Mark numbers (negative marking approach)
            for (int i = 0; i < n; i++) {
                if (arr[i] <= 0) {

                    // Replace non-positive numbers with a large value
                    arr[i] = n + 1;
                }
            }

            // Mark the indices of the numbers that exist in the array
            for (int i = 0; i < n; i++) {
                int num = Math.abs(arr[i]);
                if (num <= n) {

                    // Mark as negative to indicate the number is found
                    arr[num - 1] = -Math.abs(arr[num - 1]);
                }
            }

            // Find the first index that does not have a negative value
            for (int i = 0; i < n; i++) {
                if (arr[i] > 0) {

                    // Return the first missing positive integer
                    return i + 1;
                }
            }

            // If all numbers from 1 to n are present, return n+1
            return n + 1;
        }

        // Function to perform Binary Search to find the index of the target number
        public static int binarySearch(int[] arr, int target) {
            int left = 0;
            int right = arr.length - 1;

            // Perform binary search
            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (arr[mid] == target) {

                    // Return the index if the target is found
                    return mid;

                } else if (arr[mid] < target) {

                    // Move the left pointer to the right
                    left = mid + 1;

                } else {

                    // Move the right pointer to the left
                    right = mid - 1;
                }
            }

            // Return -1 if the target is not found
            return -1;
        }


        public static void main(String[] args) {
            //take array as example
            int[] arrForLinearSearch = {3, 4, -2, 1};
            int[] arrForBinarySearch = {-6, 1, 3, 9, 10, 12};
            int target = 3;

            // Linear Search to find the first missing positive integer
            int firstMissingPositive = findFirstMissingPositive(arrForLinearSearch);
            System.out.println("First missing positive integer: " + firstMissingPositive);

            // Binary Search to find the index of the target
            Arrays.sort(arrForBinarySearch);
            int targetIndex = binarySearch(arrForBinarySearch, target);
            if (targetIndex != -1) {
                System.out.println("Target " + target + " found at index: " + targetIndex);
            } else {
                System.out.println("Target " + target + " not found in the array.");
            }
        }


}
