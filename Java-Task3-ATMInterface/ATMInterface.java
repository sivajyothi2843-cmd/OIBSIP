import java.util.ArrayList;
import java.util.Scanner;

public class ATMInterface {

    static Scanner sc = new Scanner(System.in);
    static double balance = 10000.00;
    static ArrayList<String> transactions = new ArrayList<>();

    static final String USER_ID = "user123";
    static final int PIN = 1234;

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("          ATM INTERFACE");
        System.out.println("=================================");

        if (!login()) {
            System.out.println("Account locked.");
            System.out.println("Goodbye!");
            return;
        }

        int choice;

        do {
            System.out.println("\n========== ATM MENU ==========");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Check Balance");
            System.out.println("6. Exit");
            System.out.println("==============================");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    transactionHistory();
                    break;

                case 2:
                    withdraw();
                    break;

                case 3:
                    deposit();
                    break;

                case 4:
                    transfer();
                    break;

                case 5:
                    System.out.println("Current Balance: ₹" + balance);
                    break;

                case 6:
                    System.out.println("Thank you for using the ATM!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);

        sc.close();
    }

    static boolean login() {

        int attempts = 0;

        while (attempts < 3) {

            System.out.print("Enter User ID: ");
            String userId = sc.next();

            System.out.print("Enter PIN: ");
            int pin = sc.nextInt();

            if (userId.equals(USER_ID) && pin == PIN) {
                System.out.println("\nLogin successful!");
                return true;
            }

            attempts++;
            System.out.println("Invalid User ID or PIN.");
            System.out.println("Attempts remaining: " + (3 - attempts));
        }

        return false;
    }

    static void transactionHistory() {

        System.out.println("\n====== TRANSACTION HISTORY ======");

        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String transaction : transactions) {
                System.out.println(transaction);
            }
        }
    }

    static void withdraw() {

        System.out.print("Enter withdrawal amount: ₹");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            transactions.add("Withdrawn: ₹" + amount);

            System.out.println("Withdrawal successful!");
            System.out.println("Remaining Balance: ₹" + balance);
        }
    }

    static void deposit() {

        System.out.print("Enter deposit amount: ₹");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount.");
        } else {
            balance += amount;
            transactions.add("Deposited: ₹" + amount);

            System.out.println("Deposit successful!");
            System.out.println("Current Balance: ₹" + balance);
        }
    }

    static void transfer() {

        System.out.print("Enter recipient account ID: ");
        String recipient = sc.next();

        System.out.print("Enter transfer amount: ₹");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;

            transactions.add(
                "Transferred ₹" + amount + " to " + recipient
            );

            System.out.println("Transfer successful!");
            System.out.println("Remaining Balance: ₹" + balance);
        }
    }
}
