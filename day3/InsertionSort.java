package com.week3.day3;
import java.util.*;

public class InsertionSort{
    // Method to perform Insertion Sort on employee IDs
    public static void insertionSort(int[] employeeIDs) {
        int n = employeeIDs.length;

        // Traverse through the array from the second element
        for (int i = 1; i < n; i++) {
            int key = employeeIDs[i]; // Pick the current element
            int j = i - 1;

            // Move elements of the sorted part that are greater than key one position ahead
            while (j >= 0 && employeeIDs[j] > key) {
                employeeIDs[j + 1] = employeeIDs[j];
                j--;
            }

            // Insert the key at the correct position
            employeeIDs[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        // Initialize an array with employee IDs
        int[] employeeIDs = {101, 105, 118, 110, 103, 108};

        // Print the original employee IDs before sorting
        System.out.println("Original Employee IDs: " + Arrays.toString(employeeIDs));

        // Call insertionSort method to sort the employee IDs
        insertionSort(employeeIDs);

        // Print  sorted employee IDs after applying Insertion Sort
        System.out.println("Sorted Employee IDs: " + Arrays.toString(employeeIDs));
    }
}

