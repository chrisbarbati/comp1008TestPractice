package com.example.testpractice;

import java.util.Arrays;
import java.util.List;

public class Account {
    /***
     * Bank account class.
     */
    private double balance;
    private int accountHolder;

    private int accountNumber = Main.accounts.size() + 1;
    private String accountType;

    public Account(int customerNumber, String accountType) {
        setBalance(balance);
        setAccountNumber(accountNumber);
        setAccountHolder(customerNumber);
        setAccountType(accountType);
        System.out.println("New account created. \nAccount Number: "+ accountNumber + "\nAccount Holder: "
                + accountHolder + " \nBalance: " + balance + " \nAccount Type: " + accountType + "\n\n");
    }

    public double getBalance() {
        return balance;
    }

    /**
     *
     * @param balance represents account balance. Can be negative if account is overdrawn. Starts at zero
     */
    public void setBalance(double balance) {
        this.balance = 0;
    }

    public int getAccountNumber() {
        return accountNumber;
    }


    /**
     *
     * @param accountNumber represents next account number to be assigned. Passed from Main, using the
     *                      size of the accounts ArrayList to determine the next free account number.
     */
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAccountHolder() {
        return accountHolder;
    }

    /**
     *
     * @param customerNumber represents the customer number of the account holder. Passed from main, uses
     *                       size of ArrayList to determine which customer object is the
     *                       account holder.
     */
    public void setAccountHolder(int customerNumber) {
        this.accountHolder = customerNumber;
    }

    /**
     * When called, this method returns the valid types of account. To add a new type of account, add it
     * to this list, otherwise an exception will be thrown.
     * @return
     */
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
