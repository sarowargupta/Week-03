package com.day6;
public class RecursiveVsIterativeFibonacci {
    // method for Recursive Fibonacci (O(2ⁿ))
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // method for Iterative Fibonacci (O(N))
    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        //Test case array
        int[] testCases = {10, 30, 50};

        for (int n : testCases) {
            System.out.println("\nFibonacci of " + n + ":");

            // Measure time for Recursive Fibonacci : Case1
            if (n > 30) {
                System.out.println("Unfeasible");
            } else {

                long startTime = System.nanoTime();
                fibonacciRecursive(n);
                long endTime = System.nanoTime();
                System.out.println("Recursive  Time: " + (endTime - startTime) / 1000000.0 + " ms");
            }

            // Measure time for Iterative : Case2
            long startTimeIterative = System.nanoTime();
            fibonacciIterative(n);
            long endTimeIterative = System.nanoTime();
            System.out.println("Iterative result Time: " + (endTimeIterative - startTimeIterative) / 1000000.0 + " ms");

        }
    }


}


