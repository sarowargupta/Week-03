package com.day4.FileReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileLineByLine {
        public static void main(String[] args) {
            //file path
            String filePath  ="src/main/java/com/day4/FileReader/Line.txt";

            //Wrap the FileReader in a BufferReader
            try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
                String Line;

                //read line by line
                while((Line = br.readLine())!=null){

                    //display each line
                    System.out.println(Line);
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }

        }
}
