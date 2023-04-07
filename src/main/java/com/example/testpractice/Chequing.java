package com.example.testpractice;

public class Chequing extends Account{
    private static double interestRate = 0.01;

    public String getAccountType() {
        return accountType;
    }

    private static String accountType = "Chequing";
    public Chequing() {
    }

    /**
     * Chequing accounts are a subclass of account, which has a base interest rate of 1%.
     * @return
     */

    public static double getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(double interestRate) {
        Chequing.interestRate = interestRate;
    }
}
