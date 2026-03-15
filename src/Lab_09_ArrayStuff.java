import java.util.Random;
import java.util.Scanner;

public class Lab_09_ArrayStuff {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rnd = new Random();

        // --- Part 1 ---

        // Task 1: Declare an int array named dataPoints with a length of 100
        int[] dataPoints = new int[100];

        // Task 2: Initialize each element to a random value between 1 and 100
        for (int i = 0; i < dataPoints.length; i++) {
            dataPoints[i] = rnd.nextInt(100) + 1;
        }

        // Task 3: Display the values separated by " | "
        for (int i = 0; i < dataPoints.length; i++) {
            System.out.print(dataPoints[i] + " | ");
        }
        System.out.println("\n"); // Move to the next line for cleaner output

        // Task 4: Calculate and display the sum and average
        int sum = 0;
        for (int i = 0; i < dataPoints.length; i++) {
            sum += dataPoints[i];
        }
        int average = sum / dataPoints.length;
        System.out.println("The sum of the random array dataPoints is: " + sum);
        System.out.println("The average of the random array dataPoints is: " + average);
        System.out.println();


        // --- Part 2: Linear Scan ---

        // Task 5: Prompt user for an int between 1 and 100
        int userValue1 = SafeInput.getRangedInt(in, "Enter an integer to search for", 1, 100);

        // Task 6: Count how many times the user's value is found
        int matchCount = 0;
        for (int i = 0; i < dataPoints.length; i++) {
            if (dataPoints[i] == userValue1) {
                matchCount++;
            }
        }
        System.out.println("The value " + userValue1 + " was found " + matchCount + " times in the array.\n");

        // Task 7: Prompt again, find first position, and short circuit (break)
        int userValue2 = SafeInput.getRangedInt(in, "Enter another integer to find its first position", 1, 100);
        boolean found = false;

        for (int i = 0; i < dataPoints.length; i++) {
            if (dataPoints[i] == userValue2) {
                System.out.println("The value " + userValue2 + " was found at array index " + i);
                found = true;
                break; // Short circuits the loop
            }
        }
        if (!found) {
            System.out.println("The value " + userValue2 + " was not found in the array.");
        }
        System.out.println();

        // Task 8: Scan for min and max values
        int min = dataPoints[0]; // Assume first element is the min initially
        int max = dataPoints[0]; // Assume first element is the max initially

        for (int i = 1; i < dataPoints.length; i++) {
            if (dataPoints[i] < min) {
                min = dataPoints[i];
            }
            if (dataPoints[i] > max) {
                max = dataPoints[i];
            }
        }
        System.out.println("The minimum value in the array is: " + min);
        System.out.println("The maximum value in the array is: " + max);
        System.out.println();

        // Task 9: Call the static getAverage method
        System.out.println("Average of dataPoints is: " + getAverage(dataPoints));

        in.close();
    }

    // Task 9 Static Method (Placed outside of main, but inside the class)
    public static double getAverage(int values[]) {
        double totalSum = 0;
        for (int i = 0; i < values.length; i++) {
            totalSum += values[i];
        }
        return totalSum / values.length; // Returns a double because totalSum is a double
    }
}