/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.managment.system;

import java.util.Date;

/**
 *
 * @author Karim Ashraf
 */
public class Transaction {
     private static int transactionCounter = 0;
    private int transactionId;
    private String type; // Deposit, Withdrawal, Transfer, Request, Approval
    private double amount;
    private Date date;
    private int customerId;
    private int otherPartyId;

    public Transaction(String type, double amount, int customerId, int otherPartyId) {
        this.transactionId = ++transactionCounter;
        this.type = type;
        this.amount = amount;
        this.date = new Date();
        this.customerId = customerId;
        this.otherPartyId = otherPartyId;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Transaction ID: " + transactionId + ", Type: " + type + ", Amount: " + amount +
                ", Date: " + date + ", Customer ID: " + customerId + ", Other Party ID: " + otherPartyId;
    }
}
  

