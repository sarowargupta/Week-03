package com.day4.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;

public class ReadAndWrite {
        public static void main(String[] args) {
            // File path to store the user input
            String filePath = "src/main/java/com/day4/InputStreamReader/Read.txt";

            // Create InputStreamReader to read from System.in (console input)
            try (InputStreamReader isr = new InputStreamReader(System.in);
                 BufferedReader br = new BufferedReader(isr);
                 FileWriter writer = new FileWriter(filePath, true)) { // true to append to the file

                String input;

                System.out.println("Enter text (type 'exit' to stop):");

                // Read user input until 'exit' is entered
                while (true) {
                    input = br.readLine();  // Read a line of input

                    if ("exit".equalsIgnoreCase(input)) {
                        break;  // Stop input when user types 'exit'
                    }

                    // Write the input to the file with a new line
                    writer.write(input + System.lineSeparator());
                }

                System.out.println("Input has been written to the file.");

            } catch (IOException e) {
                // Handle any IO exceptions
                e.printStackTrace();
            }
        }


}
