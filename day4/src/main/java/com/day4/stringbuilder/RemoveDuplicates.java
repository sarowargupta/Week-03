package com.day4.stringbuilder;
import java.util.HashSet;

public class RemoveDuplicates {

        //method to remove duplicate and form a string
        public static String removeDuplicate(String str){

            //create a string builder object
            StringBuilder sb = new StringBuilder();

            //create a hashset for storing non duplicate
            HashSet<Character> characters = new HashSet<>();
            for(char ch : str.toCharArray()){
                if(!characters.contains(ch)){
                    characters.add(ch);
                    sb.append(ch);
                }

            }
            //return string
            return sb.toString();
        }

        public static void main(String[] args) {
            //String variable input
            String input = "Hello";

            //call the method remove Duplicate
            String result = removeDuplicate(input);

            //print the string after removing duplicate character
            System.out.println("String after removing duplicate Character: " + result);
        }

}
