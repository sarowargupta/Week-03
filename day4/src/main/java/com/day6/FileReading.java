package com.day6;
import java.io.*;

public class FileReading {
    // Method to measure FileReader performance
    public static long measureFileReader(String filePath) {
        long startTime = System.currentTimeMillis();
        try (FileReader reader = new FileReader(filePath)) {
            while (reader.read() != -1) {
                // Reading character by character
            }
        } catch (IOException e) {
            System.out.println("Error reading file with FileReader: " + e.getMessage());
        }
        return System.currentTimeMillis() - startTime;
    }

    // Method to measure InputStreamReader performance
    public static long measureInputStreamReader(String filePath) {
        long startTime = System.currentTimeMillis();
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(filePath))) {
            while (reader.read() != -1) {
                // Reading byte by byte and converting to characters
            }
        } catch (IOException e) {
            System.out.println("Error reading file with InputStreamReader: " + e.getMessage());
        }
        return System.currentTimeMillis() - startTime;
    }
    public static void main(String[] args) {
        String[] filePaths = {
                //  file path for 1MB file
                "src/main/java/com/day6/1MBSize.txt",

                //  file path for 100MB file
                "src/main/java/com/day6/100MBSize.txt",

                //  file path for 500MB file
                "src/main/java/com/day6/500MBSize.txt"
        };

        for (String filePath : filePaths) {
            System.out.println("File: " + filePath);

            //call the method of file reader for calculating performance
            long fileReaderTime = measureFileReader(filePath);
            System.out.println("FileReader time: " + fileReaderTime + " ms");

            //call the method of input stream reader for calculating performance
            long inputStreamReaderTime = measureInputStreamReader(filePath);
            System.out.println("InputStreamReader time: " + inputStreamReaderTime + " ms");
        }
    }

}

