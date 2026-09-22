package cc.ku.ict.module2.calculator;

public class CalculatorMain {

    // The 'add' method to be called
    // The add function (method) you provided
    public static int add(int a, int b) {
        int sum = a + b;
        return sum; // Returns the integer result
    }

    // The main method - the entry point of the program
    public static void main(String[] args) {

        // Calling the add function and storing the result in a variable
        int result = add(5, 3); // Passing 5 and 3 as arguments

        // Printing the result to the console
        System.out.println("The sum is: " + result);

        // You can also call the method directly inside println
        System.out.println("Another sum: " + add(10, 20)); // Prints: Another sum: 30

        // You can use variables as arguments too
        int num1 = 15;
        int num2 = 25;
        int total = add(num1, num2);
        System.out.println("The sum of " + num1 + " and " + num2 + " is " + total);
    }
}
