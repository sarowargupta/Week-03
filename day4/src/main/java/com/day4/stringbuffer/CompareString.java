package com.day4.stringbuffer;

public class CompareString {
        public static long[] compareStringBufferByStringBuilder(String input){
            long startTime, endTime;

            //Measure time for StringBuilder
            startTime = System.nanoTime();
            StringBuilder sb = new StringBuilder();
            for(int i= 0;i<100000;i++){
                sb.append(input);
            }
            endTime = System.nanoTime();
           long resultStringBuilder=endTime-startTime;

           //Measure time for StringBuffer
            startTime = System.nanoTime();
            StringBuffer sbf = new StringBuffer();
            for(int i= 0;i<100000;i++){
                sbf.append(input);
            }
            endTime = System.nanoTime();
            long resultStringBuffer=endTime - startTime;

            //return the result as an array
            return new long[]{resultStringBuilder,resultStringBuffer};
        }

        public static void main(String[] args) {
            // String variable assign hello
            String input = "hello";

            //call method to calculate time of concatenation process or StringBuilder and StringBuffer
            long result[] = compareStringBufferByStringBuilder(input);

            //print the result time taken by string builder
            System.out.println("StringBuilder Time is :" + result[0]+ " nanosecond");

            //print the result time taken by string buffer
            System.out.println("StringBuffer Time is :" + result[1]+ " nanosecond");

            // Compare and print which one is faster
            if (result[0] < result[1]) {
                System.out.println("StringBuilder is faster by " + (result[1] - result[0])  + " nanoseconds.");
            } else {
                System.out.println("StringBuffer is faster by " + (result[0] - result[1]) + " nanoseconds.");
            }

        }

}
