package com.day4.InputStreamReader;
import java.io.*;

public class CompareChallenge {

    // Method to count words in a large file using FileReader and InputStreamReader
    public static long countWordsInFile(String filePath) throws IOException {
        long wordCount = 0;

        // Using FileReader and InputStreamReader
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath));
             BufferedReader br = new BufferedReader(isr)) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }
        }
        //return word count
        return wordCount;
    }
    public static void main(String[] args) throws IOException {
        // String concatenation test: Test-1
        //String concatenation using string builder
        String str = "hello";
        long startTime, endTime;
        startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for(int i= 0;i<100000;i++){
            sb.append(str);
        }
        endTime = System.nanoTime();
        long stringBuilderTime = endTime - startTime;
        System.out.println("StringBuilder Time is :" + stringBuilderTime + " nanosecond");

        //String concatenation using string buffer
        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for(int i= 0;i<100000;i++){
            sbf.append(str);
        }
        endTime = System.nanoTime();
        long stringBufferTime = endTime - startTime;
        System.out.println("StringBuffer Time is :" + stringBufferTime + " nanosecond");

        // File reading test:Test-2
        String filePath = "src/main/java/com/day4/InputStreamReader/Compare.txt"; // Replace with the path to your 100MB file
        long wordCount = countWordsInFile(filePath);
        System.out.println("Word count in file: " + wordCount);
    }


}
