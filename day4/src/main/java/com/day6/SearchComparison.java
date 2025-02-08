package com.day6;
import java.util.Arrays;
import java.util.Random;

public class SearchComparison {
    // Generate a random array of given size
    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size );  // Random numbers in a large range
        }
        return array;
    }

    // Linear Search: O(N)
    public static int linearSearch(int[] data, int target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                return i;
            }
        }
        // Not found
        return -1;
    }

    // Binary Search: O(log N)
    public static int binarySearch(int[] data, int target) {
        int left = 0;
        int right = data.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (data[mid] == target) {
                return mid;
            } else if (data[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // Not found
        return -1;
    }
    public static void main(String[] args) {
        // Dataset sizes for testing
        int[] datasetSizes = {1000, 10000, 1000000};
        Random random = new Random();

        for (int size : datasetSizes) {
            System.out.println("Dataset Size: " + size);

            //generate random array
            int[] data = generateRandomArray(size);

            //generate random target from the dataset
            int target = data[random.nextInt(size)];

            // Linear Search: Case1
            long startTime = System.nanoTime();

            //call the method for linear search
            linearSearch(data, target);
            long endTime = System.nanoTime();
            long linearSearchTime = endTime - startTime;

            //print linear search time
            System.out.println("Linear Search Time: " + linearSearchTime / 1000000.0 + " ms");

            // Binary Search (sorted data) :Case2
            // O(N log N)
            Arrays.sort(data);
            startTime = System.nanoTime();

            //call the method for binary search
            binarySearch(data, target);
            endTime = System.nanoTime();
            long binarySearchTime = endTime - startTime;
            //print binary search time
            System.out.println("Binary Search Time (including sorting): " + binarySearchTime / 1000000.0 + " ms");
        }
    }


}

