/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.managment.system;

/**
 *
 * @author Karim Ashraf
 */
class Admin {
    private String adminId;
    private String password;

    public Admin(String adminId, String password) {
        this.adminId = adminId;
        this.password = password;
    }

    public boolean login(String adminId, String password) {
        return this.adminId.equals(adminId) && this.password.equals(password);
    }

    public void addCustomer(Bank bank, int customerId, Customer customer) {
        bank.createCustomerAccount(customerId, customer);
    }

    public void deleteCustomer(Bank bank, int customerId) {
        if (bank.searchCustomerAccount(customerId) != null) {
            bank.customers.remove(customerId);
            System.out.println("Customer removed successfully.");
        } else {
            System.out.println("Customer not found.");
        }
    }

    public void modifyCustomerDetails(Customer customer, String name, String address) {
        customer.name = name;
        customer.address = address;
        System.out.println("Customer details updated.");
    }

    public void viewAllTransactions(Bank bank) {
        bank.displayAllTransactions();
    }
}
