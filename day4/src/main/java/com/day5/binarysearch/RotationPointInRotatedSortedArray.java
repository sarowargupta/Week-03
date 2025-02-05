package com.day5.binarysearch;

public class RotationPointInRotatedSortedArray {
        //method to find rotation point
        public static int findRotationPoint(int[] arr) {
            int left = 0;
            int right = arr.length - 1;

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] > arr[right]) {
                    // Rotation point is in the right half
                    left = mid + 1;
                } else {
                    // Rotation point is in the left half (including mid)
                    right = mid;
                }
            }

            // The index of the smallest element (rotation point)
            return left;
        }

        public static void main(String[] args) {
            //  rotated sorted array
            int[] arr = {10,10,10,1,8,9};

            //call method to find rotation point
            int rotationPointIndex = findRotationPoint(arr);

            //print the rotation point index and value store at that index
            System.out.println("The rotation point index is: " + rotationPointIndex);
            System.out.println("The smallest element is: " + arr[rotationPointIndex]);
        }


}
