import java.util.ArrayList;
import java.util.Scanner;

// Base class
class Account {
    String accountHolder;
    double balance;
    ArrayList<String> transactionHistory = new ArrayList<>();

    Account(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        transactionHistory.add("Account created with balance: ₹" + initialBalance);
    }

    void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposited: ₹" + amount);
        System.out.println("Deposit successful.");
    }

    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            transactionHistory.add("Withdrawn: ₹" + amount);
            System.out.println("Withdrawal successful.");
        }
    }

    void viewBalance() {
        System.out.println("Current balance: ₹" + balance);
    }

    void viewTransactions() {
        System.out.println("Transaction History:");
        for (String t : transactionHistory) {
            System.out.println("- " + t);
        }
    }
}

// Subclass (optional: shows inheritance)
class SavingsAccount extends Account {
    SavingsAccount(String accountHolder, double initialBalance) {
        super(accountHolder, initialBalance);
    }

    @Override
    void withdraw(double amount) {
        System.out.println("[Savings Account] Processing withdrawal...");
        super.withdraw(amount); // Call base class method
    }
}

// Main class
public class BankApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter initial balance: ₹");
        double balance = sc.nextDouble();

        // Using the subclass to show inheritance
        Account userAccount = new SavingsAccount(name, balance);

        boolean running = true;
        while (running) {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. View Balance");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ₹");
                    double dep = sc.nextDouble();
                    userAccount.deposit(dep);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ₹");
                    double wd = sc.nextDouble();
                    userAccount.withdraw(wd);
                    break;

                case 3:
                    userAccount.viewBalance();
                    break;

                case 4:
                    userAccount.viewTransactions();
                    break;

                case 5:
                    running = false;
                    System.out.println("Thank you for using the Bank App!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
