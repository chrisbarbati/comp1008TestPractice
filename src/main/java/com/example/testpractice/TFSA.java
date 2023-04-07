package com.example.testpractice;

public class TFSA extends Account{
    private static double interestRate = 0.05;
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
     * @return
     */
    public static double getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(double interestRate) {
        TFSA.interestRate = interestRate;
    }

    public double getContributionLimit() {
        return contributionLimit;
    }

    public void setContributionLimit(double contributionLimit) {
        this.contributionLimit = contributionLimit;
    }
}
