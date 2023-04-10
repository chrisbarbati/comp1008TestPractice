package com.example.testpractice;

public class Savings extends Account{
    private double interestRate = 0.02;

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
    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        if(interestRate >= 0 && interestRate <= 1){
            this.interestRate = interestRate;
        }else{
            throw new IllegalArgumentException("Interest rate must be in range 0-1, inclusive");
        }
    }
}
