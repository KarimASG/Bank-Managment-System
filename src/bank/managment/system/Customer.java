/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.managment.system;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author Karim Ashraf
 */
public class Customer {
     private int customerId;
    String name;
    String address;
    private double balance;
    private String accountType; // Savings or Current
    private PriorityQueue<Transaction> transactionHistory = new PriorityQueue<>(
            Comparator.comparing(Transaction::getDate).reversed()
    );

    public Customer(int customerId, String name, String address, double initialDeposit, String accountType) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.balance = initialDeposit;
        this.accountType = accountType;
    }

    // Deposit money
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount!");
            return;
        }
        balance += amount;
        System.out.println("Deposit successful! New Balance: " + balance);
    }

    // Withdraw money
    public void withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            System.out.println("Invalid withdrawal amount or insufficient balance!");
            return;
        }
        balance -= amount;
        System.out.println("Withdrawal successful! New Balance: " + balance);
    }

    // Transfer money
    public void transferMoney(Customer receiver, double amount) {
        if (amount <= 0 || amount > balance) {
            System.out.println("Invalid transfer amount or insufficient balance!");
            return;
        }
        this.withdraw(amount);
        receiver.deposit(amount);
        System.out.println("Transfer successful to Customer ID: " + receiver.customerId);
    }

    // Display account details
    public void displayAccountDetails() {
        System.out.println("Customer ID: " + customerId);
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Account Balance: " + balance);
        System.out.println("Account Type: " + accountType);
    }

    // Display transaction history
    public void displayTransactionHistory() {
        transactionHistory.forEach(System.out::println);
    }
}
    

