package com.example.testpractice;

import java.util.ArrayList;

public class Account {
    /***
     * Bank account class. Instance variables
     */
    private double balance;
    private String accountType;

    private Double interestRate;

    /**
     * Master ArrayList of all accounts.
     */
    static ArrayList<Account> accountsList = new ArrayList<>();
    private int accountNumber = accountsList.size();

    public Account(String accountType) {
        //Balance starts at zero
        setBalance(0);

        setAccountType(accountType);

        //Each account is numbered according to it's List index
        setAccountNumber(accountNumber);
    }

    private void setInterestRate(Double interestRate){
        this.interestRate = interestRate;
    }


    /**
     * Add validation later. Chequing, Savings, TFSA
     * @param accountType
     * @return
     */
    public void setAccountType(String accountType){

        this.accountType = accountType;

        if(accountType == "Chequing"){
            setInterestRate(0.01);
        }else if(accountType == "Savings"){
            setInterestRate(0.05);
        }else if(accountType == "TFSA"){
            setInterestRate(0.03);
        }else{
            throw new IllegalArgumentException("Valid account types are Chequing, Savings, and TFSA");
        }
    }

    public double getBalance() {
        return balance;
    }

    /**
     * Balance starts at zero. This method is not accessed in normal use (usually one would use withdraw or deposit).
     * Negative balances are rejected.
     * @param balance
     */
    public void setBalance(double balance) {
        if(balance >= 0){
            this.balance = balance;
        }else{
            throw new IllegalArgumentException(balance + " received. Accounts cannot be set to a balance below zero");
        }
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     *
     * @param accountNumber represents next account number to be assigned. Passed from Main, using the
     *                      size of the accounts ArrayList to determine the next free account number.
     *                      Must be greater than or equal to zero.
     */
    public void setAccountNumber(int accountNumber) {
        if(accountNumber >= 0) {
            this.accountNumber = accountNumber;
        }else{
            throw new IllegalArgumentException(accountNumber + " received. Account numbers must be greater than zero.");
        }
    }

    /**
     * Deposited amount must be greater than zero
     * @param amount
     */
    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
            System.out.println("Deposit of " + String.format("$%.2f", amount) + " is processed.");
            System.out.println("Account Balance " + String.format("$%.2f", balance) + "\n");
        }else{
            throw new IllegalArgumentException(amount + " received. Amount must be greater than zero.");
        }
    }

    /**
     *  Withdrawal amount must be greater than zero. Must not result in a negative balance.
     * @param amount
     */
    public void withdraw(double amount){
        if(amount > 0 && balance-amount >= 0) {
            balance -= amount;
            System.out.println("Withdrawal of " + String.format("$%.2f", amount) + " is processed.");
            System.out.println("Account Balance " + String.format("$%.2f", balance) + "\n");
        }
        else if(amount <= 0){
            throw new IllegalArgumentException(amount + " received. Amount must be greater than zero.");
        }
        else if(balance-amount < 0){
            throw new IllegalArgumentException(amount + " cannot be withdrawn. Funds insufficient.");
        }
    }

    public String getAccountType() {
        return accountType;
    }

    /**
     * Function to allow an EFT between two accounts. Allows for transfers both between a customer's own accounts,
     * and also for transfers between different customer's accounts.
     *
     * Passes to the deposit and withdraw functions, so makes use of their validation as well.
     * @param amount
     * @param sender
     * @param recipient
     */
    public static void fundsTransfer(double amount, int sender, int recipient){
        if(accountsList.get(recipient) == accountsList.get(sender)){
            throw new IllegalArgumentException("Sender and Receiver accounts cannot be the same");
        }if(recipient < 0 || recipient > Account.accountsList.size() - 1){
            throw new IndexOutOfBoundsException("Sender account number " + recipient + " is invalid.");
        }if(sender < 0 || sender > Account.accountsList.size() - 1) {
            throw new IndexOutOfBoundsException("Recipient account number " + sender + " is invalid.");
        }if(amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero.");
        }else{
            accountsList.get(sender).withdraw(amount);
            accountsList.get(recipient).deposit(amount);
        }
    }
}
