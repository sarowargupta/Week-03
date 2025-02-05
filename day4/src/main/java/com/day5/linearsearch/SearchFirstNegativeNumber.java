package com.day5.linearsearch;

public class SearchFirstNegativeNumber {

           //method to find first negative number
        public static int findFirstNegative(int[] arr) {
            //iterate loop through length of the array
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < 0) {

                    // Return the index of the first negative number
                    return i;
                }
            }
            // Return -1 if no negative number is found
            return -1;
        }

        public static void main(String[] args) {
            //Initialize array with numbers with positive and negative
            int[] numbers = {1, -5, -7, 7, 8, -6};

            //call the method check number is negative and return index
            int index = findFirstNegative(numbers);

            //check first negative number found or not
            if (index != -1) {
                System.out.println("First negative number found at index: " + index);
            } else {
                System.out.println("No negative number found in the array.");
            }
        }

}
