package cc.ku.ict.module3.exercises.exercise4;


public class BankAccount {
    // Attributes of the Bank Account
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private String accountType;

    // Default constructor
    public BankAccount() {
        this.accountNumber = "000000";
        this.accountHolder = "Unnamed";
        this.balance = 0.0;
        this.accountType = "Checking";
    }

    // Parameterized constructor
    public BankAccount(String accountNumber, String accountHolder, double balance, String accountType) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.accountType = accountType;
    }

    // Getter and setter methods
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    // Balance is modified via deposit and withdrawal methods
    private void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    // Method to deposit amount
    public void deposit(double amount) {
        if (amount > 0) {
            setBalance(balance + amount);
            System.out.println(amount + " deposited successfully.");
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Method to withdraw amount
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            setBalance(balance - amount);
            System.out.println(amount + " withdrawn successfully.");
        } else {
            System.out.println("Invalid withdrawal. Check balance and amount.");
        }
    }

    // Method to display account details
    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Type: " + accountType);
        System.out.println("Balance: " + balance);
    }


}

