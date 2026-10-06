package cc.ku.ict.module3.extendedcircleobject;

import java.util.Scanner;

public class CircleMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String again; // holds the user's yes/no answer between iterations

        // A do-while loop is used instead of a while loop because we want
        // to ask for circle details AT LEAST ONCE before ever checking
        // whether the user wants to continue.
        do {
            System.out.println("\n--- Enter details for a new Circle ---");

            System.out.print("Enter x coordinate: ");
            int x = scanner.nextInt();

            System.out.print("Enter y coordinate: ");
            int y = scanner.nextInt();

            System.out.print("Enter radius: ");
            int radius = scanner.nextInt();

            scanner.nextLine(); // consumes the leftover newline after nextInt(),
            // otherwise the next nextLine() call below would
            // read an empty string instead of waiting for input.

            System.out.print("Enter color: ");
            String color = scanner.nextLine();

            System.out.print("Enter label: ");
            String label = scanner.nextLine();

            // All five values are known only at this point, so the full
            // constructor is the right one to call here.
            Circle circle = new Circle(x, y, radius, color, label);

            System.out.println("\nThe new circle object is: " + circle);
            System.out.println("Area: " + circle.calculateArea());
            System.out.println("Circumference: " + circle.calculateCircumference());

            System.out.print("\nAnother circle? (yes/no): ");
            again = scanner.nextLine();

            // .trim() removes accidental leading/trailing spaces the user
            // might type; .equalsIgnoreCase() accepts "Yes", "YES", "yes", etc.
        } while (again.trim().equalsIgnoreCase("yes"));

        System.out.println("\nGoodbye!");
        scanner.close();
    }
}