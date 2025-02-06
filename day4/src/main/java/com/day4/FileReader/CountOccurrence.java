package com.day4.FileReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountOccurrence {
        public static void main(String[] args) {
            //filePath
            String filePath = "src/main/java/com/day4/FileReader/Count.txt";
            String target = "java";
            String[] result;
            int count =0;
            //wrap the fileReader in a BufferReader
            try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
                String Line;
                while((Line= br.readLine())!=null){
                    //split the line into words
                    result = Line.split("\\s+|[^a-zA-Z]+");

                    //count occurrence of the target word
                    for(String res : result){
                        if(res.equalsIgnoreCase(target)){
                            count++;
                        }
                    }
                    //print the final count
                    System.out.println("Target word " + target + " appears " + count + " times ");
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }


}
