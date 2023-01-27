package com.example.testpractice;

import java.util.Arrays;
import java.util.List;

public class Account {
    /***
     * Bank account.
     */
    private double balance;
    private int accountNumber, accountHolder;
    private String accountType;

    public Account(double balance, int accountNumber, int accountHolder, String accountType) {
        setBalance(balance);
        setAccountNumber(accountNumber);
        setAccountHolder(accountHolder);
        setAccountType(accountType);
        System.out.println("New account created. \nBalance: " + balance + " \nNumber: "+ accountNumber
                + " \nAccount Holder: " + accountHolder + " \nAccount Type: " + accountType);
    }

    public double getBalance() {
        return balance;
    }

    /**
     *
     * @param balance represents account balance. Can be negative if account is overdrawn
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     *
     * @param accountNumber represents account number. Must be greater than zero, must be unique.
     */
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAccountHolder() {
        return accountHolder;
    }

    /**
     *
     * @param accountHolder represents the customer number of the account holder. Must be greater than zero,
     *                      must be unique, must be one that is already allocated to a customer.
     */
    public void setAccountHolder(int accountHolder) {
        if(Customer.displayAssignedCustomerNumbers().contains(Integer.toString(accountHolder))) {
            this.accountHolder = accountHolder;
        }else{
            throw new IllegalArgumentException("Customer number " + accountHolder + " has not been assigned to a customer.");
        }
    }

    public static List<String> getValidAccountTypes()
    {
        return Arrays.asList("chequing", "savings", "tfsa");
    }

    public String getAccountType() {
        return accountType;
    }

    /**
     *
     * @param accountType represents the type of account. Chequing, savings, TFSA, etc.
     */
    public void setAccountType(String accountType) {
        accountType = accountType.toLowerCase();

        List<String> validAccountTypes = getValidAccountTypes();
        if(validAccountTypes.contains(accountType)) {
            this.accountType = accountType;
        }
        else{
            throw new IllegalArgumentException(accountType + " is not a valid account type. Options are " +
                    "Chequing, Savings, TFSA");
        }
    }
}
