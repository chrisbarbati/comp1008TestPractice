package com.example.testpractice;

public class TFSA extends Account{
    private double interestRate = 0.05;
    private double contributionLimit;

    public String getAccountType() {
        return accountType;
    }

    private static String accountType = "TFSA";

    public TFSA() {;
    }

    /**
     * TFSA is a subclass of account. They have a base interest rate of 5% and a contribution limit to be determined
     * based upon the age of the owner.
     * Note: Removed contribution limit as the scope of the project is too broad to include it. Left the interest rate,
     * in order to have a reason each subclass is different from one another.
     * @return
     */
    public double getInterestRate() {
        return interestRate;
    }

    /**
     * Interest rate must be between 0 and 1. While rates outside of this range are possible,
     * they are incredibly unlikely.
     * @param interestRate
     */
    public void setInterestRate(double interestRate) {
        if(interestRate >= 0 && interestRate <= 1){
            this.interestRate = interestRate;
        }else{
            throw new IllegalArgumentException("Interest rate must be in range 0-1, inclusive");
        }
    }


}
