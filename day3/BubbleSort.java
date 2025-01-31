package com.week3.day3;
import java.util.*;

public class BubbleSort {
    //method for sort marks in ascending order
    public static void bubbleSort(int[] marks){
        boolean swapped;

        //Outer loop to traverse through the array
        for(int i=0;i<marks.length;i++){
            swapped = false;
            //for each step max item will come at the last index
           for(int j =1;j< marks.length-i;j++){

               //if number is greater than  next then swap
               if(marks[j]<marks[j-1]){
                   int temp = marks[j];
                   marks[j] = marks[j-1];
                   marks[j-1] = temp;
                   swapped = true;
               }
           }

            // If no two elements were swapped in inner loop, array is already sorted
           if(!swapped){
               break;
           }
        }
    }


    public static void main(String[] args) {
        //marks of student store in an array
        int[] marks = {78,90,55,88,86,84,95};

        //print marks before applying bubble sort
        System.out.println("Sorted Student marks: " + Arrays.toString(marks));

        //call the method to the marks in ascending order
        bubbleSort(marks);

        //print marks in ascending order after applying bubble sort
        System.out.println("Sorted Student marks: " + Arrays.toString(marks));
    }
}
