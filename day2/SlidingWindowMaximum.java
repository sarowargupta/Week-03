package com.week3.day2;
import java.util.*;

public class SlidingWindowMaximum {

    // Function to find the maximum element in each sliding window
    public static void findSlidingWindowMaximum(int[] nums, int k) {
        // Deque to store indices of useful elements for each window
        Deque<Integer> deque = new LinkedList<>();

        // Array to store the result
        int[] result = new int[nums.length - k + 1];

        // Iterate through each element in the array
        for (int i = 0; i < nums.length; i++) {
            // Remove elements from deque that are out of the current window
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove elements from deque
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            // Add the current index to the deque
            deque.offerLast(i);

            //  current max is the element at the front of the deque
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        // Print the result
        System.out.println(Arrays.toString(result));
    }

    public static void main(String[] args) {

        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        // Call function to find sliding window maximums
        findSlidingWindowMaximum(nums, k);
    }
}

