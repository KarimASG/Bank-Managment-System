/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.managment.system;

import java.util.Scanner;

/**
 *
 * @author Karim Ashraf
 */
public class BankManagmentSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Bank bank = new Bank("MyBank", "123 Main St", "IFSC12345");
        Admin admin = new Admin("admin123", "password123");
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Banking System Menu ---");
            System.out.println("1. Admin Login");
            System.out.println("2. Customer Options");
            System.out.println("3. Display Bank Details");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // Admin operations
                    System.out.print("Enter Admin ID: ");
                    String adminId = scanner.next();
                    System.out.print("Enter Password: ");
                    String password = scanner.next();
                    if (admin.login(adminId, password)) {
                        System.out.println("Admin login successful!");
                        handleAdminMenu(bank, admin, scanner);
                    } else {
                        System.out.println("Invalid credentials.");
                    }
                    break;
                case 2: // Customer operations
                    handleCustomerMenu(bank, scanner);
                    break;
                case 3: // Display bank details
                    bank.displayBankDetails();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        scanner.close();
    }
 private static void handleAdminMenu(Bank bank, Admin admin, Scanner scanner) {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. Add Customer");
            System.out.println("2. Delete Customer");
            System.out.println("3. View All Customers");
            System.out.println("4. View All Transactions");
            System.out.println("5. Back");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Customer ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Address: ");
                    String address = scanner.next();
                    System.out.print("Enter Initial Deposit: ");
                    double deposit = scanner.nextDouble();
                    System.out.print("Enter Account Type (Savings/Current): ");
                    String type = scanner.next();
                    admin.addCustomer(bank, id, new Customer(id, name, address, deposit, type));
                    break;
                case 2:
                    System.out.print("Enter Customer ID to delete: ");
                    int deleteId = scanner.nextInt();
                    admin.deleteCustomer(bank, deleteId);
                    break;
                case 3:
                    bank.displayAllCustomers();
                    break;
                case 4:
                    admin.viewAllTransactions(bank);
                    break;
                case 5:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void handleCustomerMenu(Bank bank, Scanner scanner) {
        System.out.print("Enter Customer ID: ");
        int customerId = scanner.nextInt();
        Customer customer = bank.searchCustomerAccount(customerId);
        if (customer == null) {
            System.out.println("Customer not found!");
            return;
        }

        boolean back = false;
        while (!back) {
            System.out.println("\n--- Customer Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer Money");
            System.out.println("4. Display Account Details");
            System.out.println("5. View Transaction History");
            System.out.println("6. Back");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double deposit = scanner.nextDouble();
                    customer.deposit(deposit);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdraw = scanner.nextDouble();
                    customer.withdraw(withdraw);
                    break;
                case 3:
                    System.out.print("Enter Receiver Customer ID: ");
                    int receiverId = scanner.nextInt();
                    Customer receiver = bank.searchCustomerAccount(receiverId);
                    if (receiver == null) {
                        System.out.println("Receiver not found!");
                        break;
                    }
                    System.out.print("Enter amount to transfer: ");
                    double amount = scanner.nextDouble();
                    customer.transferMoney(receiver, amount);
                    break;
                case 4:
                    customer.displayAccountDetails();
                    break;
                case 5:
                    customer.displayTransactionHistory();
                    break;
                case 6:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}

  