/**
 * Must be stored as CircleMain.java
 *
 * This is the "driver class". It contains the main method,
 * which is the starting point of the program.
 */
package cc.ku.ict.module3.circleobject;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CircleMain
{
    public static void main(String[] s)
    {
        // ============================
        // 1. Instantiating a Circle object using the default constructor
        // ============================
        // IMPORTANT: This only works if Circle has a no-argument constructor (Circle()).
        // Otherwise, you need to add one in Circle class.
        Circle circleObject = new Circle();

        // Printing the circle's details (calls the toString() method)
        System.out.println(circleObject.toString());

        // ============================
        // 2. Instantiating a Circle object using a constructor with parameters
        // ============================

        // Example: Circle with center (20,20), radius 3, color "Blue"
        // Circle circle1 = new Circle(20, 20, 3, "Blue");

        // System.out.println(circle1.toString());    // Prints circle details
        // System.out.println(circle1.calculateArea()); // Prints area of the circle

        // ============================
        // 3. Using constructor directly in print statements
        // ============================

        // System.out.println(new Circle(50, 40, 100));  // Constructor with 3 parameters
        // System.out.println(new Circle(25, 50));       // Constructor with 2 parameters

        // ============================
        // 4. Using variables for constructor parameters
        // ============================

        // short temp = 5;   // Declaring and initializing a short variable
        // System.out.println(new Circle(40, 50, temp)); // Passing variable as radius

        // ============================
        // 5. Taking user input (Scanner class)
        // ============================

        // Scanner input = new Scanner(System.in);  // Instantiate Scanner object

        // System.out.print("Enter the radius: ");
        // int radius = input.nextInt();            // Read an integer from keyboard

        // Circle circle4 = new Circle(20, 20, radius);  // Use input for radius
        // System.out.println(circle4);                  // Print details
        // System.out.println(circle4.calculateArea());  // Print area

        // ============================
        // 6. Encapsulation: Using getters instead of direct field access
        // ============================

        // System.out.println(circle4.getX());   // Correct way (through getter)
        // System.out.println(circle4.x);        // WRONG: causes error (x is private)

        // ============================
        // 7. Formatting numeric output
        // ============================

        // DecimalFormat fmt = new DecimalFormat("0.####"); // Format: 4 decimal places
        // System.out.println(fmt.format(circle4.calculateArea()));
    }
}
