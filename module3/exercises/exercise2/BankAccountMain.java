package cc.ku.ict.module3.exercises.exercise2;

public class BankAccountMain {


    public static void main(String[] args) {

        BankAccount account1 = new BankAccount();

        BankAccount account2 = new BankAccount("2","Jane Roe",30.0,"Checking");

        System.out.println(account1);
        System.out.println(account2);

        account2.withdraw(10);
        System.out.println(account2);

        account2.deposit(60);

        System.out.println(account2);

    }
}
