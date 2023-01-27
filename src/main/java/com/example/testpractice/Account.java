package com.example.testpractice;

public class Account {
    /***
     * Bank account.
     */
    private double balance;
    private int accountNumber, accountHolder;
    private String accountType;

    public Account(double balance, int accountNumber, int accountHolder, String accountType) {
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
        this.accountHolder = accountHolder;
    }

    public String getAccountType() {
        return accountType;
    }

    /**
     *
     * @param accountType represents the type of account. Chequing, savings, TFSA, etc.
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
