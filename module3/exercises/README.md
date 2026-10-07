# Hands-on Exercise 1


* Define the package `cict.module3.circleobject` in your Java project.
* Place your Java files (`Circle.java`, `CircleMain.java` given above) under this package and run the application.
* We would like to use this circle in a 3-dimensional plane. Please add a z-coordinate and the related constructors to
  the Circle class, and update the main method properly to demonstrate instantiating a new Circle object in a 3-dimensional plane.
* Add a method to calculate circumference, and call it in the main method.
  - Define a new method `calculateCircumference()` using the formula:

    ```
    Circumference = 2 × π × radius
    ```

  - (Note: The circumference is the perimeter of a circle.)



***


# Hands-on Exercise 2: Bank Account Application

## Requirement List

We want to develop a simple Bank Account application. A user account should have the following features:

* Store the **account number**, **account holder name**, **account type**(e.g., Savings, Checking), and **balance**.
* Allow deposits to increase the balance.
* Allow withdrawals to decrease the balance, but the balance should not go below zero.
* Display the current balance.

## Instructions

> Analyze the requirement list and design the Bank Account class and objects by following these steps:

1. **Identify the class**
  - Determine the class name from the requirement (e.g., `BankAccount`).

2. **Identify attributes (fields/properties)**
  - Determine which data should be stored in the class (account number, holder name, balance, account type, etc.).

3. **Define constructors**
  - Include constructors to initialize account attributes.
  - Provide a default constructor and a parameterized constructor with all key attributes.

4. **Identify methods (behaviors/functions)**
  - Determine which actions the account should perform (deposit, withdraw, display balance, etc.).

5. **Apply encapsulation**
  - Declare attributes as `private`.
  - Provide getter and setter methods for accessing and modifying attributes where appropriate.

6. **Implement account operations**
  - Implement deposit and withdrawal methods.
  - Ensure withdrawal cannot reduce the balance below zero.

7. **Implement display methods**
  - Provide a method to display account details, including account number, holder name, account type, and balance.

8. **Test your class**
  - In the main method of a class (e.g., `BankAccountMain`), instantiate multiple Bank Account objects.
  - Deposit and withdraw amounts using the methods.
  - Display account details and balance after each operation.

***
***
## Hands-on Exercise 3: Working with BankAccount Objects in Collections

In the previous exercise, you defined an `BankAccount` class with attributes and methods.  
Now, you will use this class with **Java Collections** (`ArrayList`) to perform practical operations.

### Instructions

**Extend your application**
- In the main method of the `BankAccountMain` class:
- Use a loop structure (e.g., `do-while`) to repeatedly:
   - Ask the user to enter the bank account details (i.e.;**account number**, **account holder name**... )
   - Instantiate a new object with these values.
   - Print the BankAccount object using `toString()`.
   - Add the object into a collection (ArrayList).
- After each iteration, ask the user whether they want to instantiate another account.
- Exit the loop if the user chooses not to continue.


* Iterate through the `ArrayList` and display accounts.
    - Use both **for loop** and **enhanced for loop** to practice iteration.
* Compute the **total balance** of all accounts in the list.
    - Do this using a loop.
    - Then repeat using **Streams** (`mapToDouble` and `sum`).
* Filter accounts based on specific criteria. Examples:
    - Accounts with balance greater than a certain amount.
    - Accounts that belong to a particular account holder.
* Sort the accounts:
    - By **account holder’s name** (alphabetical order).
    - By **balance** (ascending or descending).
    - Use **Comparator** and **Streams** for sorting.
* Print the results of each operation clearly to observe the differences.
