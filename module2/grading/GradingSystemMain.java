package cc.ku.ict.module2.grading;

import java.util.Scanner;

public class GradingSystemMain {

    // Converts a numeric score to a letter grade based on a standard scale.

    public static String convertToGrade(int score) {
        if (score >= 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else if (score >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    public static void main(String[] args) {
        // Create a Scanner object to read user input from the console
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a score
        System.out.print("Enter the student's score: ");

        // Read the integer score entered by the user
        int studentScore = scanner.nextInt();

        // Call the convertToGrade function to get the letter grade
        String letterGrade = convertToGrade(studentScore);

        // Print the result to the console
        System.out.println("The student's grade is: " + letterGrade);

        // Close the scanner object to prevent resource leaks
        scanner.close();
    }
}
