package com.example.testpractice;

public class Chequing extends Account{
    private static double interestRate = 0.05;

    public String getAccountType() {
        return accountType;
    }

    private static String accountType = "Chequing";
    public Chequing(int customerNumber) {
        super(customerNumber);
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(double interestRate) {
        Chequing.interestRate = interestRate;
    }
}