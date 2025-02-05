package com.day5.binarysearch;

public class SearchTargetValue {
   //method to find target in 2D matrix
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        //  left and right pointers for binary search
        int left = 0;
        int right = rows * cols - 1;


        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Convert mid to row and column indices
            int row = mid / cols;
            int col = mid % cols;

            int midElement = matrix[row][col];

            // Compare middle element with the target
            if (midElement == target) {
                return true;
            } else if (midElement < target) {

                // Move to the right half
                left = mid + 1;
            } else {

                // Move to the left half
                right = mid - 1;
            }
        }

        // If the target is not found
        return false;
    }

    public static void main(String[] args) {
        //2D matrix
        int[][] matrix = {
                {1, 2, 5, 6},
                {10, 11, 12, 20},
                {20, 30, 34, 60}
        };

        int target = 5;

        //call the method to find target in 2D matrix
        boolean result = searchMatrix(matrix, target);

        if (result) {
            System.out.println("Target " + target + " found in the matrix.");
        } else {
            System.out.println("Target " + target + " not found in the matrix.");
        }
    }
}
