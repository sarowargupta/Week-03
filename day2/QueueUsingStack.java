package com.week3.day2;
import java.util.Stack;

class QueueUsingTwoStacks {

    //stack for enqueue operation
    private Stack<Integer> stack1;

    //stack for dequeue operation
    private Stack<Integer> stack2;

    //Constructor for initialization
    public QueueUsingTwoStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Enqueue operation for :push into stack1
    public void enqueue(int item) {
        stack1.push(item);
    }

    // Dequeue operation :pop from stack2
    public int dequeue() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        //remove and return the top element of stack
        return stack2.pop();
    }

    // Peek operation
    public int peek() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        //return the top element of stack
        return stack2.peek();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        if (stack1.isEmpty() && stack2.isEmpty()){
            return true;
        }
        return false;
    }

}


public class QueueUsingStack {
    public static void main(String[] args) {

        //object of queue class
        QueueUsingTwoStacks queue = new QueueUsingTwoStacks();
        //add element in stack1
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        //dequeue from stack2 and print the element
        System.out.println(queue.dequeue());

        //dequeue from stack2 and print the element
        System.out.println(queue.dequeue());

        //peek the top element of stack2
        System.out.println(queue.peek());

        //check queue is empty
        System.out.println(queue.isEmpty());
    }
}
