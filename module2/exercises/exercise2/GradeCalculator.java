package cc.ku.ict.module2.exercises.exercise2;

import java.util.Scanner;

/**
 * A simple program to calculate a weighted total grade based on midterm and final scores.
 */
public class GradeCalculator {

    public static void main(String[] args) {
        // Create a Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);

        // Declare variables to store the grades
        byte midtermGrade;
        byte finalGrade;
        double totalGrade;

        // Prompt the user for the midterm grade
        System.out.print("Enter the midterm grade: ");
        midtermGrade = scanner.nextByte();

        // Prompt the user for the final grade
        System.out.print("Enter the final grade: ");
        finalGrade = scanner.nextByte();

        // Confirm the grades entered by the user
        System.out.println("\nMidterm Grade entered: " + midtermGrade);
        System.out.println("Final Grade entered: " + finalGrade);

        // Calculate the total grade using the specified weights (40% for midterm, 60% for final)
        totalGrade = (midtermGrade * 0.40) + (finalGrade * 0.60);

        // Print the final calculated total grade
        System.out.println("\nCalculated total grade: " + totalGrade);

        // Close the scanner object to free up resources
        scanner.close();
    }
}