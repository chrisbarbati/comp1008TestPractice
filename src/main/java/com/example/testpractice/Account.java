package com.example.testpractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Account {
    /***
     * Bank account.
     */
    private double balance;
    private int accountNumber, accountHolder;

    private static int currentAccountNumber = 0;
    private String accountType;

    static ArrayList<String> validAccountNumber = new ArrayList<String>();

    public Account(int accountHolder, String accountType) {
        setBalance(balance);
        setAccountNumber(accountNumber);
        setAccountHolder(accountHolder);
        setAccountType(accountType);
        System.out.println("New account created. \nBalance: " + balance + " \nNumber: "+ accountNumber
                + " \nAccount Holder: " + accountHolder + " \nAccount Type: " + accountType + "\n\n");
    }

    public double getBalance() {
        return balance;
    }

    /**
     *
     * @param balance represents account balance. Can be negative if account is overdrawn
     */
    public void setBalance(double balance) {
        this.balance = 0;
    }

    public int getAccountNumber() {
        return accountNumber;
    }


    /**
     *
     * @param currentAccountNumber represents next account number to be assigned.
     *                           Must be unique, assigned sequentially.
     */
    public void setAccountNumber(int currentAccountNumber) {
        currentAccountNumber++;
        this.accountNumber = currentAccountNumber;
        validAccountNumber.add(Integer.toString(this.accountNumber));
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

    public static ArrayList displayAssignedAccountNumbers(){
        return validAccountNumber;
    }
}
