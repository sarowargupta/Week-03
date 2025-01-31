package com.week3.day2;
import java.util.*;

class CircularTour {
    static class Pump {
        int petrol;
        int distance;

        // Constructor to hold petrol and distance for each pump
        Pump(int petrol, int distance) {
            this.petrol = petrol;
            this.distance = distance;
        }
    }

    // Function to find the starting petrol pump index using a queue
    public static int circularTour(int[] petrol, int[] distance) {
        // To track the total surplus petrol
        int totalSurplus = 0;

        // To track the surplus petrol from the current start
        int currentSurplus = 0;

        // Start from pump 0
        int start = 0;

        // Create a queue to simulate the circular tour
        Queue<Pump> queue = new LinkedList<>();

        // Enqueue all the pumps into the queue
        for (int i = 0; i < petrol.length; i++) {
            queue.add(new Pump(petrol[i], distance[i]));
        }

        // Simulate the tour
        while (!queue.isEmpty()) {
            Pump currentPump = queue.poll();

            // Calculate the surplus petrol for this pump
            totalSurplus += currentPump.petrol - currentPump.distance;
            currentSurplus += currentPump.petrol - currentPump.distance;

            // If currentSurplus becomes negative
            // it means we cannot start the tour from this point
            if (currentSurplus < 0) {
                // Reset the starting point to the next pump
                start++;
                currentSurplus = 0;
            }

            // Check if we have visited all pumps
            if (start >= petrol.length) {
                break;
            }
        }


        return totalSurplus >= 0 ? start : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};  // Petrol available at each pump
        int[] distance = {6, 5, 3, 5};  // Distance to the next pump

        //call the method circular tour
        int result = circularTour(petrol, distance);

        if (result == -1) {
            System.out.println("No valid starting point found for the circular tour.");
        } else {
            System.out.println("The tour can start from pump " + result);
        }
    }
}

