package com.week3.day2;
import java.util.Stack;

public class StockSpan {

    // Function to calculate the stock span for each day
    public static void calculateStockSpan(int[] prices) {
        // Stack to store indices of prices
        Stack<Integer> stack = new Stack<>();

        // Array to store the span for each day
        int[] span = new int[prices.length];

        // Loop through each price
        for (int i = 0; i < prices.length; i++) {
            // Pop elements from stack while the price is greater than the top price of the stack
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // If stack is empty, the span is the entire period (i+1)
            if (stack.isEmpty()) {
                span[i] = i + 1;
            } else {
                // difference between  current index and  index of the last greater price
                span[i] = i - stack.peek();
            }

            // Push the current index onto the stack
            stack.push(i);
        }

        // Print the span of each day
        for (int i = 0; i < span.length; i++) {
            System.out.print(span[i] + " ");
        }
    }


    public static void main(String[] args) {
        // Example stock prices array
        int[] prices = {100, 80, 60, 70, 60, 75, 85};

        // Call function to calculate stock span
        calculateStockSpan(prices);
    }
}

