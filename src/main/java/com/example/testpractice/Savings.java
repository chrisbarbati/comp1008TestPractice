package com.example.testpractice;

public class Savings extends Account{
    private static double interestRate = 0.02;

    public String getAccountType() {
        return accountType;
    }

    private static String accountType = "Savings";
    public Savings() {
    }

    /**
     * Savings accounts are a subclass of Account. Savings accounts have a default interest rate of 2%
     * @return
     */
    public static double getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(double interestRate) {
        Savings.interestRate = interestRate;
    }
}
