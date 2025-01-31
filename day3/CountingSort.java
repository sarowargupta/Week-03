package com.week3.day3;
import java.util.*;

public class CountingSort {
    // Method to perform Counting Sort on student ages
    public static void countingSort(int[] ages, int maxAge) {
        int n = ages.length;
        // Count array to store frequency
        int[] count = new int[maxAge + 1];

        // Output array to store sorted ages
        int[] output = new int[n];

        // Count the occurrences of each age
        for (int age : ages) {
            count[age]++;
        }

        // Compute cumulative frequencies
        for (int i = 1; i <= maxAge; i++) {
            count[i] += count[i - 1];
        }

        // Place elements in their correct positions in the output array
        for (int i = n - 1; i >= 0; i--) {
            output[count[ages[i]] - 1] = ages[i];
            count[ages[i]]--;
        }

        // Copy sorted elements back to the original array
        System.arraycopy(output, 0, ages, 0, n);
    }

    public static void main(String[] args) {
        // Initialize an array with student age
        // age  from 10 to 18
        int[] studentAges = {12, 15, 16 , 10, 18, 14, 13, 12, 15, 11, 17};
        int maxAge = 18; // Maximum possible age

        // Print the original student ages before sorting
        System.out.println("Original Ages: " + Arrays.toString(studentAges));

        // Call countingSort method to sort the ages
        countingSort(studentAges, maxAge);

        // Print the sorted student ages after applying Counting Sort
        System.out.println("Sorted Ages: " + Arrays.toString(studentAges));
    }
}
