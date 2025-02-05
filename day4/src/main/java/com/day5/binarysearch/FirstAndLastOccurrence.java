package com.day5.binarysearch;
public class FirstAndLastOccurrence{

    // method to find the first occurrence of the target
    public static int findFirstOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int firstIndex = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                // Target is found, update the first index
                firstIndex = mid;

                // Move right pointer left to search for first occurrence
                right = mid - 1;

            } else if (arr[mid] < target) {

                // Move left pointer right to search the right half
                left = mid + 1;
            } else {

                // Move right pointer left to search the left half
                right = mid - 1;
            }
        }
        // Return the first index where the target was found, or -1 if not found
        return firstIndex;
    }

    // method to find the last occurrence of the target
    public static int findLastOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int lastIndex = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                // Target is found, update the last index
                lastIndex = mid;

                // Move left pointer right to search for last occurrence
                left = mid + 1;
            } else if (arr[mid] < target) {

                // Move left pointer right to search the right half
                left = mid + 1;
            } else {

                // Move right pointer left to search the left half
                right = mid - 1;
            }
        }

        return lastIndex;
    }

    // Main function to find both first and last occurrence
    public static int[] findFirstAndLast(int[] arr, int target) {
        int[] result = new int[2];
        result[0] = findFirstOccurrence(arr, target);
        result[1] = findLastOccurrence(arr, target);
        return result;
    }

    public static void main(String[] args) {
        //array example
        int[] arr = {5, 7, 7, 8, 8, 8, 10};

        //target value to search
        int target = 7;

        //call the method find first and last occurrence of target
        int[] result = findFirstAndLast(arr, target);

        //print the result
        if (result[0] == -1) {
            System.out.println("Target " + target + " not found in the array.");
        } else {
            System.out.println("First occurrence of " + target + " is at index: " + result[0]);
            System.out.println("Last occurrence of " + target + " is at index: " + result[1]);
        }
    }
}

