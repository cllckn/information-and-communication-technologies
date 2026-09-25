package cc.ku.ict.module2.exercises.exercise3;

/**
 * Demonstrates array iteration, modular function design,
 * value-returning methods, and helper function composition.
 */
public class ShoppingCart {


    public static void main(String[] args) {

        // ==========================================
        // Task 1: Displaying Item Prices with a Loop
        // ==========================================

        // Declare and initialize the itemPrices array
        double[] itemPrices = {19.99, 5.50, 75.00, 2.99};

        System.out.println("--- Individual Item Prices ---");

        // Traditional for-loop: Iterates from index 0 up to (itemPrices.length - 1)
        for (int i = 0; i < itemPrices.length; i++) {
            // Access each element using array indexing syntax: arrayName[index]
            System.out.println("Item " + (i + 1) + " price: $" + itemPrices[i]);
        }

        // ==========================================
        // Task 2: Function Execution & Total Return
        // ==========================================

        // Call calculateTotal, passing itemPrices array as an argument.
        // The return value is assigned to the local variable 'cartTotal'.
        double cartTotal = calculateTotal(itemPrices);

        System.out.println("\n--- Shopping Cart Summary ---");
        System.out.println("Cart Total (including 10% tax): $" + cartTotal);
    }

    /**
     * Optional Challenge Method: Calculates tax on a given amount.

     * Key Concept: Single Responsibility Principle (SRP) / High Cohesion
     * - This function does exactly one thing: applies a 10% tax rate.
     */
    private static double calculateTax(double price) {
        double taxRate = 0.10;
        return price + (price * taxRate);
    }

    /**
     * Task 2: Calculates the total cost of all items in an array.

     * Key Concepts:
     * - Abstraction (Black Box): The caller passes an array and receives a sum
     *   without needing to manage the loop logic directly.
     * - Reusability (DRY): Can calculate totals for any double array passed to it.
     */
    public static double calculateTotal(double[] prices) {
        // Accumulator variable to hold the running sum
        double sum = 0.0;

        // Loop through the input array to aggregate individual prices
        for (double price : prices) {
            sum += price; // Equivalent to: sum = sum + prices[i]
        }

        // Additional Challenge: Delegate tax calculation to helper method
        double finalTotalWithTax = calculateTax(sum);

        // Return keyword sends the calculated result back to the caller frame
        return finalTotalWithTax;
    }

}