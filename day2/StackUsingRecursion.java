package com.week3.day2;
import java.util.Stack;

public class StackUsingRecursion  {
    //function to pop stack
    public static void sortStack(Stack<Integer> stack) {
        //if the stack is empty
        if(stack.isEmpty()){
            return;
        }
        else {
            //pop the top element and store in temp
            int temp = stack.pop();

            //Recursively pop elements
            sortStack(stack);

            //insert the pop element
            insertSorted(stack, temp);
        }
    }

    private static void insertSorted(Stack<Integer> stack, int element)
    {   //sort the remaining stack
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
        } else {
            int temp = stack.pop();
            insertSorted(stack, element);
            stack.push(temp);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        //push elements to the stack
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        //print original stack
        System.out.println("Original Stack: " + stack);

        //stack after sort
        sortStack(stack);
        System.out.println("Sorted Stack: " + stack);
    }
}




