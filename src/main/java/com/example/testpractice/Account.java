package com.example.testpractice;

import java.util.ArrayList;

public class Account {
    /***
     * Bank account class.
     */
    private double balance;
    private int accountHolder;

    public String getAccountType() {
        return accountType;
    }

    private String accountType;

    /**
     * Master ArrayList of all accounts.
     */
    static ArrayList<Account> accountsList = new ArrayList<>();
    private int accountNumber = accountsList.size();

    public Account(int customerNumber) {
        //Balance starts at zero
        setBalance(0);

        //Each account is numbered according to it's List index
        setAccountNumber(accountNumber);

        //One customer can hold multiple accounts
        setAccountHolder(customerNumber);
    }

    public double getBalance() {
        return balance;
    }

    /**
     *
     * @param balance represents account balance. Can be negative if account is overdrawn. Starts at zero
     */
    public void setBalance(double balance) {
        this.balance = balance;
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

    public void deposit(double amount){
        balance += amount;
        System.out.println("Deposit of " + String.format("$%.2f", amount) + " is processed.");
        System.out.println("Account Balance " + String.format("$%.2f", balance) + "\n");
    }

    public void withdraw(double amount){
        balance -= amount;
        System.out.println("Withdrawal of " + String.format("$%.2f", amount) + " is processed.");
        System.out.println("Account Balance " + String.format("$%.2f", balance) + "\n");
    }

    public void fundsTransfer(double amount, int sender, int recipient){
        //Update recipient account balance
        accountsList.get(recipient).setBalance(accountsList.get(recipient).getBalance() + amount);

        //Update sender account balance
        accountsList.get(sender).setBalance(accountsList.get(sender).getBalance() - amount);

        //Print output to console
        System.out.println("Electronic funds transfer completed.");
        System.out.println("Recipient account " + accountsList.get(recipient).getAccountNumber() + " credited " + String.format("$%.2f", amount)
                + ", new balance " + String.format("$%.2f", accountsList.get(recipient).getBalance()));
        System.out.println("Sender account " + accountsList.get(sender).getAccountNumber() + " debited " + String.format("$%.2f", amount)
                + ", new balance " + String.format("$%.2f", accountsList.get(sender).getBalance()));
    }
}
