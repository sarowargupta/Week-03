package com.week3.day3;
import java.util.*;

public class SelectionSort {
    // Method to perform Selection Sort on exam scores
    public static void selectionSort(int[] scores) {
        int n = scores.length;

        // Traverse through the array
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in the unsorted part
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first unsorted element
            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }
    }

    public static void main(String[] args) {
        // Initialize an array with exam scores
        int[] examScores = {90, 65, 80, 75, 79, 95, 89};

        // Print the original exam scores before sorting
        System.out.println("Original Scores: " + Arrays.toString(examScores));

        // Call selectionSort method to sort the scores
        selectionSort(examScores);

        // Print the sorted exam scores after applying Selection Sort
        System.out.println("Sorted Scores: " + Arrays.toString(examScores));
    }
}

