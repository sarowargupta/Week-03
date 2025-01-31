package com.week3.day3;
import java.util.*;

public class MergeSort {
    // Method to perform Merge Sort on book prices
    public static void mergeSort(int[] prices, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Recursively divide the array into two halves
            mergeSort(prices, left, mid);
            mergeSort(prices, mid + 1, right);

            // Merge the sorted halves
            merge(prices, left, mid, right);
        }
    }

    // Method to merge two sorted subarrays
    public static void merge(int[] prices, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++) {
            leftArray[i] = prices[left + i];
        }
        for (int j = 0; j < n2; j++){
            rightArray[j] = prices[mid + 1 + j];
        }
        int i = 0, j = 0, k = left;

        // Merge the temporary arrays back into the original array
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                prices[k] = leftArray[i];
                i++;
            } else {
                prices[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements from leftArray
        while (i < n1) {
            prices[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy any remaining elements from rightArray
        while (j < n2) {
            prices[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        // Initialize an array with book prices
        int[] bookPrices = {259, 100, 500, 150, 449, 225, 240};

        // Print the sorted book prices
        System.out.println("Original unsorted Prices: " + Arrays.toString(bookPrices));

        // Call mergeSort method to sort the prices
        mergeSort(bookPrices, 0, bookPrices.length - 1);

        // Print the sorted book prices after applying Merge Sort
        System.out.println("Sorted Prices: " + Arrays.toString(bookPrices));
    }
}
