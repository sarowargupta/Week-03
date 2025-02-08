package com.day6;

public class StringConcatenation {
    //method for Concatenation using String (O(N²))
    public static String concatenateWithString(int count) {
        String result = "";
        for (int i = 0; i < count; i++) {
            result += "hello";
        }
        return result;
    }

    // method for Concatenation using StringBuilder (O(N))
    public static String concatenateWithStringBuilder(int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append("hello");
        }
        return sb.toString();
    }

    //method for Concatenation using StringBuffer (O(N))
    public static String concatenateWithStringBuffer(int count) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < count; i++) {
            sb.append("hello");
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        //operation count for comparison
        int[] operationCounts = {1000, 10000, 1000000};

        for (int count : operationCounts) {
            System.out.println("\nOperation Count: " + count);

            // Test String concatenation (O(N²)): Case1
            if(count<=10000) {
                long startTime = System.nanoTime();
                concatenateWithString(count);
                long endTime = System.nanoTime();
                System.out.println("String Time: " + (endTime - startTime) / 1000000.0 + " ms");
            } else {
                System.out.println("Unusable");
            }
            // Test StringBuilder concatenation (O(N)) : Case2
            long startTime = System.nanoTime();
            concatenateWithStringBuilder(count);
            long endTime = System.nanoTime();
            System.out.println("StringBuilder Time: " + (endTime - startTime) / 1000000.0 + " ms");

            // Test StringBuffer concatenation (O(N)) : Case3
            startTime = System.nanoTime();
            concatenateWithStringBuffer(count);
            endTime = System.nanoTime();
            System.out.println("StringBuffer Time: " + (endTime - startTime) / 1000000.0 + " ms");
        }
    }


}
