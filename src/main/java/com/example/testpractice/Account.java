package com.example.testpractice;

import java.util.Arrays;
import java.util.List;

public class Account {
    /***
     * Bank account class.
     */
    private double balance;
    private int accountHolder;

    private int accountNumber = Main.accounts.size();
    private String accountType;

    public Account(int customerNumber, String accountType) {
        setBalance(balance);
        setAccountNumber(accountNumber);
        setAccountHolder(customerNumber);
        setAccountType(accountType);

        //Only prints for account numbers > 0, so no output is printed for dummy account.
        if(customerNumber > 0) {
            System.out.println("New account created. \nAccount Number: " + accountNumber + "\nAccount Holder: "
                    + accountHolder + " \nBalance: " + String.format("$%.2f", balance) + " \nAccount Type: " + accountType + "\n\n");
        }
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

    /**
     * To add a new type of account, add it to this list, otherwise an exception will be thrown.
     * @return Returns valid account types
     */
    private static List<String> getValidAccountTypes()
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
        Main.accounts.get(recipient).setBalance(Main.accounts.get(recipient).getBalance() + amount);

        //Update sender account balance
        Main.accounts.get(sender).setBalance(Main.accounts.get(sender).getBalance() - amount);

        //Print output to console
        System.out.println("Electronic funds transfer completed.");
        System.out.println("Recipient account " + Main.accounts.get(recipient).getAccountNumber() + " credited " + String.format("$%.2f", amount)
                + ", new balance " + String.format("$%.2f", Main.accounts.get(recipient).getBalance()));
        System.out.println("Sender account " + Main.accounts.get(sender).getAccountNumber() + " debited " + String.format("$%.2f", amount)
                + ", new balance " + String.format("$%.2f", Main.accounts.get(sender).getBalance()));
    }
}
