package cc.ku.ict.module3.exercises.exercise2;

public class BankAccount {

    private String accountNumber;
    private String holderName;
    private double balance;
    private String accountType;

    public BankAccount(String accountNumber, String holderName, double balance, String accountType) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
        this.accountType = accountType;
    }

    public BankAccount() {
        this.accountNumber = "unknown";
        this.holderName = "unknown";
        this.balance = 0.0;
        this.accountType = "unknown";
    }


    public void withdraw(double amount) {
        if (balance >= amount)
            this.balance -= amount;
        else
            System.out.println("Insufficient funds");
    }

    public void deposit(double amount) {
            this.balance += amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", holderName='" + holderName + '\'' +
                ", balance=" + balance +
                ", accountType='" + accountType + '\'' +
                '}';
    }
}
