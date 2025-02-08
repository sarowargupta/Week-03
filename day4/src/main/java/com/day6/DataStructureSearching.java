package com.day6;
import java.util.*;

public class DataStructureSearching{
    public static void main(String[] args) {
        //Dataset Size array
        int[] datasetSizes = {1000, 100000, 1000000};

        for (int size : datasetSizes) {
            System.out.println("\nDataset Size: " + size);

            // Generate dataset
            List<Integer> arrayList = new ArrayList<>();
            HashSet<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();

            for (int i = 0; i < size; i++) {
                int value = i * 2;
                arrayList.add(value);
                hashSet.add(value);
                treeSet.add(value);
            }

            // Element not in the dataset (worst case)
            int target = size * 2;

            // Measure time for Array search (linear search): Case1
            long startTime = System.nanoTime();
            arrayList.contains(target);
            long endTime = System.nanoTime();
            System.out.println("Array search: " + (endTime - startTime) / 1000000.0 + " ms");

            // Measure time for HashSet search : Case2
            startTime = System.nanoTime();
            hashSet.contains(target);
            endTime = System.nanoTime();
            System.out.println("HashSet search: " + (endTime - startTime) / 1000000.0 + " ms");

            // Measure time for TreeSet search :Case3
            startTime = System.nanoTime();
            treeSet.contains(target);
            endTime = System.nanoTime();
            System.out.println("TreeSet search: " + (endTime - startTime) / 1000000.0 + " ms");

        }
    }
}

