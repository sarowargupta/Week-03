package com.day5.binarysearch;

public class PeakElement {
     //method to find peak element
    public static int findPeakElement(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            //calculate mid
            int mid = left + (right - left) / 2;

            // Check if mid is a peak
            if ((mid == 0 || arr[mid] > arr[mid - 1]) && (mid == arr.length - 1 || arr[mid] > arr[mid + 1])) {

                // mid is a peak element
                return mid;
            } else if (mid > 0 && arr[mid - 1] > arr[mid]) {

                // Peak is in the left half
                right = mid - 1;
            } else {

                // Peak is in the right half
                left = mid + 1;
            }
        }

        // left will be the index of the peak
        return left;
    }

    public static void main(String[] args) {

        //example array
        int[] arr = {1, 30, 50, 60, 10};

        //call the method to find peak element
        int peakIndex = findPeakElement(arr);

        //print peak element index and its value store in index
        System.out.println("The peak element index is: " + peakIndex);
        System.out.println("The peak element is: " + arr[peakIndex]);
    }
}

