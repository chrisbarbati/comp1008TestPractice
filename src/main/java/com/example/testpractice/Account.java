package com.example.testpractice;

import java.util.ArrayList;

public class Account {
    /***
     * Bank account class. Instance variables
     */
    private double balance;
    private String accountType;
    private int owner;

    private Double interestRate;

    /**
     * Master ArrayList of all accounts.
     */
    static ArrayList<Account> accountsList = new ArrayList<>();
    private int accountNumber = accountsList.size();

    public Account(String accountType, int owner) {
        //Balance starts at zero
        setBalance(0);

        setAccountType(accountType);

        setOwner(owner);

        //Each account is numbered according to it's List index
        setAccountNumber(accountNumber);
    }

    public static void addAccountToDB(Account a){
        DBController.DBWrite("INSERT INTO accounts (accountNum, accountType, accountOwner) VALUES ("
                + a.getAccountNumber() + " , '"
                + a.getAccountType() + "' , "
                + a.getOwner() + ");"); //Need to find way to get owner
        System.out.println("Account added to database: " + a.getAccountNumber());
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
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

        if(accountType.equals("Chequing")){
            setInterestRate(0.01);
        }else if(accountType.equals("Savings")){
            setInterestRate(0.05);
        }else if(accountType.equals("TFSA")){
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
            throw new IllegalArgumentException(String.format("%2f", balance) + " received. Accounts cannot be set to a balance below zero");
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
            throw new IllegalArgumentException(String.format("%2f", amount) + " received. Amount must be greater than zero.");
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
            throw new IllegalArgumentException(String.format("%2f", amount) + " received. Amount must be greater than zero.");
        }
        else if(balance-amount < 0){
            throw new IllegalArgumentException(String.format("%2f", amount) + " cannot be withdrawn. Funds insufficient.");
        }
    }

    public String getAccountType() {
        return accountType;
    }

    public double getInterestRate(){
        return interestRate;
    }
}
