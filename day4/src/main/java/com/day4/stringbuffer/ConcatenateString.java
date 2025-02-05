package com.day4.stringbuffer;

public class ConcatenateString {
        //method to concatenate string
        public static String concatenateString(String[] str){

            //create a string buffer object
            StringBuffer sb = new StringBuffer();
            for(String str1 : str){
                sb.append(str1);
            }

            //return concatenate string
            return sb.toString();
        }

        public static void main(String[] args) {
            //array of string
            String[] input = {"Hello"," ","World"};

            //call concatenate method
            String result = concatenateString(input);

            //print the result
            System.out.println("Concatenate String is: " + result);
        }
}
