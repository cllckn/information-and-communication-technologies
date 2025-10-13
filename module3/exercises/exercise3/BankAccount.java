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


    public void withdraw(double amount) {
        if (balance >= amount)
            this.balance -= amount;
        else
            System.out.println("Insufficient funds");
    }

    public void deposit(double amount) {
            this.balance += amount;
    }

    public BankAccount() {
        this.accountNumber = "unknown";
        this.holderName = "unknown";
        this.balance = 0.0;
        this.accountType = "unknown";
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
