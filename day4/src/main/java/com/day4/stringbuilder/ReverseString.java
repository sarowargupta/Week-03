package com.day4.stringbuilder;

public class ReverseString {

    // Function to reverse a string using StringBuilder
    public static String reverseString(String input) {
        // Create a StringBuilder object with the input string
        StringBuilder sb = new StringBuilder(input);

        // Use the reverse() method of StringBuilder
        sb.reverse();

        // reverse string
        return sb.toString();
    }

    public static void main(String[] args) {
        // String variable assign hello
        String input = "hello";

        // Call the reverseString function and print the result
        String reversed = reverseString(input);

        //print reverse String
        System.out.println("Reversed string: " + reversed);
    }
}