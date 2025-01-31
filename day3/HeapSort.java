package com.week3.day3;
import java.util.*;

public class HeapSort{
    // Method to perform Heap Sort on salary demands
    public static void heapSort(int[] salaries) {
        int n = salaries.length;

        // Build a max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;

            // Call max heapify on the reduced heap
            heapify(salaries, i, 0);
        }
    }

    // Method to heapify a subtree with root at index i
    public static void heapify(int[] salaries, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Check if left child exists and is greater than root
        if (left < n && salaries[left] > salaries[largest]) {
            largest = left;
        }

        // Check if right child exists and is greater than largest so far
        if (right < n && salaries[right] > salaries[largest]) {
            largest = right;
        }

        // Swap and continue heapifying if root is not the largest
        if (largest != i) {
            int temp = salaries[i];
            salaries[i] = salaries[largest];
            salaries[largest] = temp;

            heapify(salaries, n, largest);
        }
    }

    public static void main(String[] args) {
        // Initialize an array with salary demands
        int[] salaryDemands = {7, 5, 7, 4, 8, 9 , 6};

        // Print the original salary demands before sorting
        System.out.println("Original Salary Demands In LPA: " + Arrays.toString(salaryDemands));

        // Call heapSort method to sort the salaries
        heapSort(salaryDemands);

        // Print the sorted salary demands after applying Heap Sort
        System.out.println("Sorted Salary Demands In LPA: " + Arrays.toString(salaryDemands));
    }
}
