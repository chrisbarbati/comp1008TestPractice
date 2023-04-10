package com.example.testpractice;

public class Chequing extends Account{
    private double interestRate = 0.01;

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
