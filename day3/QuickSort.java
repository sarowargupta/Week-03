package com.week3.day3;
import java.util.*;

public class QuickSort {
    // Method to perform Quick Sort on product prices
    public static void quickSort(int[] prices, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pivotIndex = partition(prices, low, high);

            // Recursively sort elements before and after the partition
            quickSort(prices, low, pivotIndex - 1);
            quickSort(prices, pivotIndex + 1, high);
        }
    }

    // Method to partition the array
    public static int partition(int[] prices, int low, int high) {

        // Choosing the last element as pivot
        int pivot = prices[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (prices[j] < pivot) {
                i++;
                // Swap prices[i] and prices[j]
                int temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }

        // Swap the pivot element to its correct position
        int temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        // Initialize an array with product prices
        int[] productPrices = {150, 120, 780, 50, 1000, 1500, 40};

        // Print the sorted product prices after applying Quick Sort
        System.out.println("Original unsorted Prices: " + Arrays.toString(productPrices));

        // Call quickSort method to sort the prices
        quickSort(productPrices, 0, productPrices.length - 1);

        // Print the sorted product prices after applying Quick Sort
        System.out.println("Sorted Prices: " + Arrays.toString(productPrices));
    }
}

