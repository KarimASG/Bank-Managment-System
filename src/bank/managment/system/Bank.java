/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.managment.system;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

/**
 *
 * @author Karim Ashraf
 */
public class Bank {
     private String name;
    private String address;
    private String ifscCode;
    TreeMap<Integer, Customer> customers = new TreeMap<>(); // O(log n) operations
    private List<Transaction> allTransactions = new ArrayList<>();

    public Bank(String name, String address, String ifscCode) {
        this.name = name;
        this.address = address;
        this.ifscCode = ifscCode;
    }

    // Create a new customer account
    public void createCustomerAccount(int customerId, Customer customer) {
        if (customers.containsKey(customerId)) {
            System.out.println("Customer ID already exists.");
            return;
        }
        customers.put(customerId, customer);
        System.out.println("Customer account created successfully!");
    }

    // Search for a customer account
    public Customer searchCustomerAccount(int customerId) {
        return customers.getOrDefault(customerId, null);
    }

    // Display all customer accounts
    public void displayAllCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customer accounts available.");
            return;
        }
        customers.values().forEach(System.out::println);
    }

    // Display bank details
    public void displayBankDetails() {
        System.out.println("Bank Name: " + name);
        System.out.println("Bank Address: " + address);
        System.out.println("Bank IFSC Code: " + ifscCode);
    }

    public void addTransaction(Transaction transaction) {
        allTransactions.add(transaction);
    }

    public void displayAllTransactions() {
        allTransactions.sort(Comparator.comparing(Transaction::getDate).reversed());
        allTransactions.forEach(System.out::println);
    }
}


