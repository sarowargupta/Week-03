package com.day4.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class ByteStreamToCharacterStream {

        public static void main(String[] args) {
            // Path to the binary file containing data encoded in UTF-8 or another charset
            String filePath = "src/main/java/com/day4/InputStreamReader/Stream.txt";

            // Create FileInputStream to read the file as a byte stream
            try (FileInputStream fis = new FileInputStream(filePath);
                 // Wrap the FileInputStream with InputStreamReader to convert byte stream to character stream
                 InputStreamReader isr = new InputStreamReader(fis, "UTF-8"); // Specify the charset (e.g., UTF-8)
                 // Use BufferedReader to read efficiently line by line
                 BufferedReader br = new BufferedReader(isr)) {

                String line;

                // Read the file line by line and print each line
                while ((line = br.readLine()) != null) {

                    // Print the line as characters
                    System.out.println(line);
                }

            } catch (IOException e) {

                // Handle any IO exceptions
                e.printStackTrace();
            }
        }


}
