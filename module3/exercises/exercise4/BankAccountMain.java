package cc.ku.ict.module3.exercises.exercise4;

import java.util.*;

public class BankAccountMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<BankAccount> accounts = new ArrayList<>();

        boolean continueInput = true;

        // --- Repeatedly take user input and create accounts ---
        while (continueInput) {
            System.out.print("Enter account number: ");
            String accountNumber = input.nextLine();


            System.out.print("Enter account holder name: ");
            String holderName = input.nextLine();

            System.out.print("Enter account balance: ");
            double balance = input.nextDouble();
            input.nextLine(); // consume newline

            System.out.print("Enter account balance: ");
            String accountType = input.nextLine();
            BankAccount account = new BankAccount(accountNumber, holderName, balance,accountType);
            System.out.println("Created Account: " + account.toString());

            accounts.add(account);

            System.out.print("Do you want to create another account? (y/n): ");
            String choice = input.nextLine();
            continueInput = choice.equalsIgnoreCase("y");
        }

        System.out.println("\n===== All Bank Accounts (Using for loop) =====");
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println(accounts.get(i));
        }

        System.out.println("\n===== All Bank Accounts (Using enhanced for loop) =====");
        for (BankAccount acc : accounts) {
            System.out.println(acc);
        }

        // --- Compute total balance using loop ---
        double total = 0;
        for (BankAccount acc : accounts) {
            total += acc.getBalance();
        }
        System.out.println("\nTotal balance (using loop): " + total);

        // --- Compute total balance using streams ---
        double totalStream = accounts.stream()
                .mapToDouble(BankAccount::getBalance)
                .sum();
        System.out.println("Total balance (using streams): " + totalStream);

        // --- Filter examples ---
        System.out.println("\nAccounts with balance > 1000:");
        accounts.stream()
                .filter(acc -> acc.getBalance() > 1000)
                .forEach(System.out::println);

        System.out.print("\nEnter account holder name to filter: ");
        String nameFilter = input.nextLine();
        System.out.println("Accounts belonging to " + nameFilter + ":");
        accounts.stream()
                .filter(acc -> acc.getAccountHolder().equalsIgnoreCase(nameFilter))
                .forEach(System.out::println);

        // --- Sorting examples ---
        System.out.println("\nAccounts sorted by holder name (alphabetical):");
        accounts.stream()
                .sorted(Comparator.comparing(BankAccount::getAccountHolder))
                .forEach(System.out::println);

        System.out.println("\nAccounts sorted by balance (ascending):");
        accounts.stream()
                .sorted(Comparator.comparingDouble(BankAccount::getBalance))
                .forEach(System.out::println);

        System.out.println("\nAccounts sorted by balance (descending):");
        accounts.stream()
                .sorted(Comparator.comparingDouble(BankAccount::getBalance).reversed())
                .forEach(System.out::println);

        input.close();
    }
}

