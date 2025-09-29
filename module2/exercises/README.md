# Hands-On Exercise 2: Student Grading System

## Tasks
- Define a new class with a `main` method. 
- Define variables for **midterm grade**, **final grade**, and **total grade**.
- Ask the user to enter the **midterm grade** (integer or double).
- Ask the user to enter the **final grade**.
- Store these values in the respective variables.
- Print them back to confirm input.
- Assume the weights are:
    - Midterm: **40%**
    - Final: **60%**
- Calculate the **total grade** using the formula:
  - Total Grade = (Midterm × 0.4) + (Final × 0.6)
- Print the total grade to the screen.  


# Hands-on Exercise 3: Functions and Loops in Java

## Objective

This exercise will help you practice two fundamental concepts in Java: functions that return a value and loops for traversing data.

Imagine you are building a simple e-commerce application. Your task is to calculate the total cost of items in a shopping cart.

## Task 1: Displaying Item Prices with a Loop
Your first task is to write a program that uses a for loop to display the price of each item in a shopping cart.

Instructions:
* Define a new Java class named ShoppingCart.
* Inside the main method, define a double array named itemPrices with the following values: {19.99, 5.50, 75.00, 2.99}.
* Use a for loop to iterate through the itemPrices array.
* Inside the loop, print the price of each item on a new line.

## Task 2: A Function that Returns a Value
Your next task is to define a function that calculates the total cost of all items and returns that value.

Instructions:
* Define a new function called calculateTotal within the ShoppingCart class.
* This function should take a single parameter: a double array (e.g., double[] prices).
* The function's return type should be double.
* Inside the calculateTotal function, use a for loop to sum up all the prices in the input array.
* Use the return keyword to send the final total back to the main method.
* In the main method, call calculateTotal, passing the itemPrices array as an argument. Store the returned value in a 
new double variable called cartTotal.
* Print the cartTotal to the console.


## Additional Challenges (Optional)
* Define a new method calculateTax(double price) that adds 10% to the given price and returns the result. Modify the 
calculateTotal function so that it applies a 10% tax to the total using this new method. The function should still 
return the final total.
