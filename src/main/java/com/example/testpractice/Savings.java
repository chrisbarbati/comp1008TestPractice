package com.example.testpractice;

public class Savings extends Account{
    private static double interestRate = 0.02;

    public String getAccountType() {
        return accountType;
    }

    private static String accountType = "Savings";
    public Savings(int customerNumber) {
        super(customerNumber);
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(double interestRate) {
        Savings.interestRate = interestRate;
    }
}
